package by.ishangulyyev.backend.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PointcutDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @NotBlank
    @Length(min = 2, max = 50)
    private String name;

    @NotNull
    @Positive
    private Long number;
    @NotBlank
    @Length(min = 2, max = 50)
    private String login;
}
