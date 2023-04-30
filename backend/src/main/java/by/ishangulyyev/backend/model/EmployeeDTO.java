package by.ishangulyyev.backend.model;

import by.ishangulyyev.backend.entity.type.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @Valid
    private AuthenticationRequest authentication;

    @Valid
    private PersonDTO person;

    @Positive
    private BigDecimal salary;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate startWork;

    @NotBlank
    @Length(min = 2, max = 50)
    private String position;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private EmployeeStatus status;
}
