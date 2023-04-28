package by.ishangulyyev.backend.model;

import by.ishangulyyev.backend.entity.Position;
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
    private Long id;

    private BigDecimal salary;

    private LocalDate startWork;

    private Position position;

    private EmployeeStatus status;

    private OriginDTO origin;

    private String login;
}
