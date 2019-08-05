package employee.it;

import employee.data.dao.EmployeeDao;
import employee.data.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    private  EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
    public List<Employee> getAllEmployeesPaged(int currentPage, int pageSize) {
        return employeeDao.getAllEmployeesPaged(currentPage, pageSize);
    }

    public Employee save(Employee newEmployee) {
        return employeeDao.save(newEmployee);
    }

    public Employee getEmployee(Long id) {
        Employee employee = employeeDao.getEmployee(id);
        return employee;
    }

    public Employee updateEmployee(Employee newEmployee, Long id) {
        return employeeDao.updateEmployee(newEmployee, id);
    }

    public void deleteEmployee(Long id) {
        employeeDao.deleteEmployee(id);
    }
}
