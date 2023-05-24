package by.ishangulyyev.cargomonitoring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoContent {
    private String id;
    private Double length;
    private Double width;
    private Double height;
    private Double weight;
}
