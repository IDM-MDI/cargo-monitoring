package by.ishangulyyev.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirportDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @NotBlank
    @Length(min = 2, max = 50)
    private String name;
    @Valid
    private CompanyDTO company;
    @Valid
    private OriginDTO origin;
}
