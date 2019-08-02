package employee.model;

import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Employee {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private Long birthDate;
    private String address;
    private Long bossId;
    private Double salary;

    Employee() {}

    public Employee(String firstName, String lastName, Long birthDate, String address, Long bossId, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.bossId = bossId;
        this.salary = salary;
    }
}