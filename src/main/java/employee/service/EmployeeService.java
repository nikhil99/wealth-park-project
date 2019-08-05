package employee.service;

import employee.data.dao.EmployeeDao;
import employee.data.model.Employee;
import employee.data.requestDtos.EmployeeListRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees(EmployeeListRequestDto employeeListRequestDto) {
        List<Employee> op = null;
        if (employeeListRequestDto == null) {
            return employeeDao.getAllEmployees();
        } else {
            Pageable page = null;
            if (employeeListRequestDto.getEmployeePageDto() != null) {
                page = PageRequest.of(
                        employeeListRequestDto.getEmployeePageDto().getCurrentPage(),
                        employeeListRequestDto.getEmployeePageDto().getMaxPage());
                op = employeeDao.getAllEmployeesPaged(page);

            }
            else if (employeeListRequestDto.getEmployeeFilterDto() != null) {
                 op = employeeDao.getCustomQueryResult(employeeListRequestDto.getEmployeeFilterDto(),
                        page);
            }
            return op;
        }
    }

    public Employee save(Employee newEmployee) {
        return employeeDao.save(newEmployee);
    }

    public Employee getEmployee(Long id) {
        return employeeDao.getEmployee(id);
    }


    public Employee updateEmployee(Employee newEmployee, Long id) {
        return employeeDao.updateEmployee(newEmployee, id);
    }

    public void deleteEmployee(Long id) {
        employeeDao.deleteEmployee(id);
    }
}
