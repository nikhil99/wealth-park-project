package employee.controller;

import java.util.List;
import java.util.stream.Collectors;

import employee.data.EmployeeRepository;
import employee.exception.EmployeeNotFoundException;
import employee.model.Employee;
import employee.util.EmployeeResourceAssembler;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    private final EmployeeResourceAssembler assembler;

    EmployeeController(EmployeeRepository repository,
                       EmployeeResourceAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }


    // Aggregate root

    @GetMapping("/employees")
    public Resources<Resource<Employee>> all() {

        List<Resource<Employee>> employees = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(employees,
                linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item

    @GetMapping("/employees/{id}")
    public Resource<Employee> one(@PathVariable Long id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return assembler.toResource(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setFirstName(newEmployee.getFirstName());
                    employee.setLastName(newEmployee.getLastName());
                    employee.setBirthDate(newEmployee.getBirthDate());
                    employee.setAddress(newEmployee.getAddress());
                    employee.setBossId(newEmployee.getBossId());
                    employee.setSalary(newEmployee.getSalary());
                    return repository.save(employee);
                }).orElseThrow(() ->
                    new EmployeeNotFoundException(id,"Employee to be updated doesn't exist or is deleted"));
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}