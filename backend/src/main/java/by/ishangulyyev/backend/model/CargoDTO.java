package by.ishangulyyev.backend.model;

import by.ishangulyyev.backend.entity.type.CargoStatus;
import by.ishangulyyev.backend.entity.type.CargoType;
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
    private String id;
    private CargoContentDTO content;
    private PersonDTO person;
    private CompanyDTO company;
    private AirportDTO departureAirport;
    private LocalDateTime arrivalTime;
    private CargoType type;
    private CargoStatus status;
}
