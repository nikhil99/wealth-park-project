package employee.it;

import employee.data.EmployeeRepository;
import employee.data.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EmployeeServiceImplIntegrationTest {

    @MockBean
    private EmployeeRepository employeeRepository;
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeService();
        }
    }

    @Autowired
    private EmployeeService employeeService;



    @Before
    public void setUp() {
         Employee employee = new Employee(
                "Nikhil",
                "Gulumkar",
                3l,
                "Tokyo, Minato-ku",
                4l,
                8500000d);

        Mockito.when(employeeRepository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(employee));
    }
    // write test cases here

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        Employee found = employeeService.getEmployee(1L);

        assertThat(found.getFirstName(),is("Nikhil"));
    }
}