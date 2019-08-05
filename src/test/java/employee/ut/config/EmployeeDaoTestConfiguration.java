package employee.ut.config;

import employee.data.dao.EmployeeDao;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("EmployeeService-test")
@Configuration
public class EmployeeDaoTestConfiguration {
    @Bean
    @Primary
    public EmployeeDao addressDao() {
        return Mockito.mock(EmployeeDao.class);
    }
}