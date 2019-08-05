package employee.data.requestDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeePageDto {
    private int currentPage;
    private int maxPage;
}
