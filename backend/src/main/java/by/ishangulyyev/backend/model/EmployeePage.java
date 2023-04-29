package by.ishangulyyev.backend.model;

import by.ishangulyyev.backend.entity.type.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePage {
    private String id;
    private String name;
    private String surname;
    private String position;
    private EmployeeStatus status;
}
