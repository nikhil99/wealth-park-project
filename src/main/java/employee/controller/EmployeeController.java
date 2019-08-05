package employee.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import employee.data.model.Employee;
import employee.data.requestDtos.EmployeeListRequestDto;
import employee.service.EmployeeService;
import employee.util.EmployeeResourceAssembler;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeResourceAssembler assembler;

    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeResourceAssembler assembler) {
        this.employeeService = employeeService;
        this.assembler = assembler;
    }

    // Aggregate root

    @GetMapping("/employees")
    public Resources<Resource<Employee>> all() {
        List<Resource<Employee>> employees = employeeService.getAllEmployees(null).stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(employees,
                linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }

    @PostMapping(value = "/employees",consumes = "application/json")
    public Resources<Resource<Employee>> allAny(@RequestBody(required = false) String employeeListRequestDto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        EmployeeListRequestDto employeeListRequestDtoObj =
                mapper.readValue(employeeListRequestDto, EmployeeListRequestDto.class);
        List<Resource<Employee>> employees = employeeService.getAllEmployees(employeeListRequestDtoObj).stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(employees,
                linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }
    @RequestMapping(value = "/getjson", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public String getJson(EmployeeListRequestDto json) throws JsonProcessingException {
        //your logic
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(json);
    }

    @PostMapping("/employees/new")
    public Resource<Employee> newEmployee(@RequestBody Employee newEmployee) {
        return assembler.toResource(employeeService.save(newEmployee));
    }

    // Single item

    @GetMapping("/employees/{id}")
    public Resource<Employee> one(@PathVariable Long id) {
        return assembler.toResource(employeeService.getEmployee(id));
    }

    @PutMapping("/employees/{id}")
    public Resource<Employee> updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return assembler.toResource(employeeService.updateEmployee(newEmployee, id));
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}