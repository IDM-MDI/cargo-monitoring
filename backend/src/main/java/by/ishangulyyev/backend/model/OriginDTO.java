package by.ishangulyyev.backend.model;

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
public class OriginDTO {
    @NotBlank
    @Length(min = 2, max = 50)
    private String country;

    @NotBlank
    @Length(min = 2, max = 50)
    private String city;
}
