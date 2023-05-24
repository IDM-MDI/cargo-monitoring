package by.ishangulyyev.cargomonitoring.model;

import com.google.gson.annotations.JsonAdapter;

import java.time.LocalDateTime;

import by.ishangulyyev.cargomonitoring.adapter.LocalDateTimeAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {
    private String id;
    private String qrCodeURL;
    private String pointcut;
    private Person person;
    private CargoContent content;
    private Company company;
    private Airport departureAirport;
    @JsonAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime arrivalTime;
    private String type;
    private String status;
}
