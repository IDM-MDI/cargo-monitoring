package by.ishangulyyev.backend.model;

import by.ishangulyyev.backend.entity.type.CargoStatus;
import by.ishangulyyev.backend.entity.type.CargoType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CargoDTO {
    private Long id;
    private CargoContentDTO content;
    private PersonDTO person;
    private CompanyDTO company;
    private AirportDTO departureAirport;
    private LocalDateTime arrivalTime;
    private CargoType type;
    private CargoStatus status;
}
