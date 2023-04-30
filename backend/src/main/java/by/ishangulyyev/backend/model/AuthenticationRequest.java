package by.ishangulyyev.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class AuthenticationRequest {
    @NotBlank
    @Length(min = 2, max = 50)
    private String login;

    @NotBlank
    @Length(min = 2, max = 50)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
