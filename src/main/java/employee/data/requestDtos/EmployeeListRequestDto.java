package employee.data.requestDtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeListRequestDto {
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EmployeePageDto employeePageDto;
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EmployeeFilterDto employeeFilterDto;
}
