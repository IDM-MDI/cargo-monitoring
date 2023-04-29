package by.ishangulyyev.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoContentDTO {
    private String id;
    private Double length;
    private Double width;
    private Double height;
    private Double weight;
}
