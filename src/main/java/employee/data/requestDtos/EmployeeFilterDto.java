package employee.data.requestDtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;
@Getter
@Setter
public class EmployeeFilterDto {
    @Nullable
    private Long id;
    @Nullable
    private String firstName;
    @Nullable
    private String lastName;
    @Nullable
    private Long birthDate;
    @Nullable
    private String address;
    @Nullable
    private Long bossId;
    @Nullable
    private Double salary;
}
