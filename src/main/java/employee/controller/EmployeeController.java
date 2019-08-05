package employee.controller;

import employee.data.model.Employee;
import employee.data.requestDtos.EmployeePageDto;
import employee.it.EmployeeService;
import employee.util.EmployeeResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

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
        List<Resource<Employee>> employees = employeeService.getAllEmployees().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(employees,
                linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }

    @PostMapping("/employees")
    public Resources<Resource<Employee>> allPaged(@RequestBody EmployeePageDto employeePageDto) {
        List<Resource<Employee>> employees =
                employeeService.getAllEmployeesPaged(
                        employeePageDto.getCurrentPage(),
                        employeePageDto.getMaxPage())
                        .stream()
                        .map(assembler::toResource)
                        .collect(Collectors.toList());
        return new Resources<>(employees,
                linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
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