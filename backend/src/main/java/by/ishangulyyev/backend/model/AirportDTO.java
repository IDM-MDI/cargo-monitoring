package by.ishangulyyev.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirportDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @Valid
    private OriginDTO origin;
}
