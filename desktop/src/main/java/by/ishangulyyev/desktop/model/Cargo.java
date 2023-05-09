package by.ishangulyyev.desktop.model;

import by.ishangulyyev.desktop.service.LocalDateTimeAdapter;
import com.google.gson.annotations.JsonAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {
    private String id;
    private String qrCodeURL;
    private Person person;
    private CargoContent content;
    private Company company;
    private Airport departureAirport;
    @JsonAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime arrivalTime;
    private String type;
    private String status;
}
