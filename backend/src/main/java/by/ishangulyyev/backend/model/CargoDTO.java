package by.ishangulyyev.backend.model;

import by.ishangulyyev.backend.entity.type.CargoStatus;
import by.ishangulyyev.backend.entity.type.CargoType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String qrCodeURL;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String pointcut;
    @Valid
    private CargoContentDTO content;
    @Valid
    private PersonDTO person;
    @Valid
    private CompanyDTO company;
    @Valid
    private AirportDTO departureAirport;
    @PastOrPresent
    private LocalDateTime arrivalTime;
    @NotNull
    private CargoType type;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private CargoStatus status;
}
