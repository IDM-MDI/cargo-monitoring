package by.ishangulyyev.cargomonitoring.model;

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
    private String type;
    private String popularCountry;
    private String unpopularCountry;
    private Double maxWeight;
    private Double minWeight;
}
