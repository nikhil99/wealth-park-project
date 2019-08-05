package employee.it;

import employee.data.EmployeeRepository;
import employee.data.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.AbstractList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void getAllEmployees() {
        addnEmployees(4);

        // when
        List<Employee> found = employeeRepository.findAll();

        // then
        Assert.assertThat(found.size(), samePropertyValuesAs(4));
    }

    @Test
    public void save() {
        Employee employee = new Employee(
                "Nikhil",
                "Gulumkar",
                3l,
                "Tokyo, Minato-ku",
                4l,
                8500000d);
        entityManager.persist(employee);
        entityManager.flush();

        // when
        Employee found = employeeRepository.save(employee);

        // then
        Assert.assertThat(found, samePropertyValuesAs(employee));
    }



    @Test
    public void deleteEmployee() {
        Employee employee = new Employee(
                "Nikhil",
                "Gulumkar",
                3l,
                "Tokyo, Minato-ku",
                4l,
                8500000d);
        entityManager.persist(employee);
        entityManager.flush();

        // found
        Employee found = employeeRepository.save(employee);
        // aseert employee exist
        Assert.assertThat(found, samePropertyValuesAs(employee));

        // found
        employeeRepository.deleteById(employee.getId());
        // aseert employee is deleted
        Assert.assertThat(employeeRepository.findAll().size(), is(0));
    }


    private void addnEmployees(int n) {
        for (int i = 0; i < n; i++) {
            Employee employee = new Employee(
                    "Test" + i,
                    "Gulumkar",
                    3l,
                    "Tokyo, Minato-ku",
                    4l,
                    8500000d);
            entityManager.persist(employee);
        }
        entityManager.flush();
    }

}