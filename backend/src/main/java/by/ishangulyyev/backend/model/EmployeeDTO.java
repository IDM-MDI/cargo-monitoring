package by.ishangulyyev.backend.model;

import by.ishangulyyev.backend.entity.type.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String id;
    private PersonDTO person;

    private BigDecimal salary;

    private LocalDate startWork;

    private String position;

    private EmployeeStatus status;

    private String login;
}
