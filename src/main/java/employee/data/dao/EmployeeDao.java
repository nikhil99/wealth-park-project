package employee.data.dao;

import employee.data.EmployeeRepository;
import employee.exception.EmployeeNotFoundException;
import employee.data.model.Employee;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class EmployeeDao {
    private final EmployeeRepository repository;

    public EmployeeDao(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public List<Employee> getAllEmployeesPaged(int currentPage, int pageSize) {
        Pageable firstPageWithTwoElements = PageRequest.of(currentPage, pageSize);

        return repository.findAll(firstPageWithTwoElements).getContent();
    }

    public Employee save(Employee newEmployee) {
        return repository.save(newEmployee);
    }

    public Employee getEmployee(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee updateEmployee(Employee newEmployee, Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setLastName(newEmployee.getLastName());
                    employee.setFirstName(newEmployee.getFirstName());
                    employee.setBirthDate(newEmployee.getBirthDate());
                    employee.setAddress(newEmployee.getAddress());
                    employee.setBossId(newEmployee.getBossId());
                    employee.setSalary(newEmployee.getSalary());
                    return repository.save(employee);
                }).orElseThrow(() ->
                        new EmployeeNotFoundException(id, "Employee to be updated doesn't exist or is already deleted. Id : "));
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
