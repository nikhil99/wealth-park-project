package employee.service;

import employee.data.EmployeeRepository;
import employee.data.dao.EmployeeDao;
import employee.data.model.Employee;
import employee.util.EmployeeResourceAssembler;

import java.util.List;

public class EmployeeService {
    private final EmployeeDao employeeDao;
    private final EmployeeResourceAssembler assembler;

    public EmployeeService(EmployeeRepository repository, EmployeeResourceAssembler assembler) {
        this.employeeDao=new EmployeeDao(repository);
        this.assembler=assembler;
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
    public List<Employee> getAllEmployeesPaged(int currentPage, int pageSize) {
        return employeeDao.getAllEmployeesPaged(currentPage,pageSize);
    }

    public Employee save(Employee newEmployee) {
        return employeeDao.save(newEmployee);
    }

    public Employee getEmployee(Long id) {
        Employee employee = employeeDao.getEmployee(id);
        return employee;
    }

    public Employee updateEmployee(Employee newEmployee, Long id) {
        return employeeDao.updateEmployee(newEmployee,id);
    }

    public void deleteEmployee(Long id) {
        employeeDao.deleteEmployee(id);
    }
}
