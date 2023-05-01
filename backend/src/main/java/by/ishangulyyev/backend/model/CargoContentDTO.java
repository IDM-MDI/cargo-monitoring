package by.ishangulyyev.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoContentDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @Positive
    private Double length;
    @Positive
    private Double width;
    @Positive
    private Double height;
    @Positive
    private Double weight;
}
