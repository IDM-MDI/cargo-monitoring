package by.ishangulyyev.backend.model;

import by.ishangulyyev.backend.entity.type.CargoStatus;
import by.ishangulyyev.backend.entity.type.CargoType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoPage {
    private String id;
    private String client;
    private String country;
    private CargoType type;
    private CargoStatus status;
}
