package employee.ut;

import employee.EmployeeManagementApplication;
import employee.data.dao.EmployeeDao;
import employee.data.model.Employee;
import employee.it.EmployeeService;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

@ActiveProfiles("EmployeeService-test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(EmployeeManagementApplication.class)
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testSaveEmployee() {
        Employee employee = mockEmployee();
        Mockito.when(employeeDao.save(employee))
                .thenReturn(employee);
        Employee actualEmployee = employeeService.save(employee);
        Assert.assertThat(actualEmployee, samePropertyValuesAs(employee));
    }


    @Test
    public void testListEmployees() {
        List<Employee> ret = saveNEmployees(5);
        Mockito.when(employeeDao.getAllEmployees())
                .thenReturn(ret);
        List<Employee> actualEmployeesList = employeeService.getAllEmployees();
        
        Assert.assertThat(actualEmployeesList.size(), is(5));
    }

    @Test
    public void testDeleteEmployees() {
        List<Employee> ret = saveNEmployees(5);
        Mockito.when(employeeDao.getAllEmployees())
                .thenReturn(ret);
        doAnswer(invocation -> {
            ret.remove(0);
            return null;
        }).when(employeeDao).deleteEmployee(any());
        employeeService.deleteEmployee(0l);
        List<Employee> actualEmployeesList = employeeService.getAllEmployees();
        Assert.assertThat(actualEmployeesList.size(), is(4));
    }

    @Test
    public void testUpdateEmployees() {
        
        Employee employee = mockEmployee();
        employee.setId(0L);
        Mockito.when(employeeDao.save(employee))
                .thenReturn(employee);
        Employee actualEmployee = employeeService.save(employee);
        Assert.assertThat(actualEmployee, samePropertyValuesAs(employee));
        employee.setFirstName("Carl");
        Mockito.when(employeeDao.updateEmployee(employee, 0L))
                .thenReturn(employee);
       
        Employee actualUpdatedEmployee = employeeService.updateEmployee(employee, 0L);
        Assert.assertThat(actualUpdatedEmployee, samePropertyValuesAs(employee));


    }

    private List<Employee> saveNEmployees(int n) {
        List<Employee> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Employee employee = mockEmployee();
            employee.setId((long) i);
            ret.add(employee);
            employeeDao.save(employee);
        }
        return ret;

    }

    private Employee mockEmployee() {
        return new Employee(
                "Nikhil",
                "Gulumkar",
                new DateTime().withDate(1992,9,25).getMillis(),
                "Tokyo, Minato-ku",
                4L,
                8500000d);
    }

}