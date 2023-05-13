package by.ishangulyyev.backend.model;

import by.ishangulyyev.backend.entity.type.CargoType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoStatistic {
    private Long finished;
    private CargoType type;
    private String popularCountry;
    private String unpopularCountry;
    private Double maxWeight;
    private Double minWeight;
}
