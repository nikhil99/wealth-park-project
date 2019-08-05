package employee.data;

import employee.data.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    @Query("SELECT e FROM Employee e WHERE (:firstName is null or e.firstName = :firstName) " +
            "and (:lastName is null or e.lastName = :lastName) ")
   List<Employee> findEmployeeByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}