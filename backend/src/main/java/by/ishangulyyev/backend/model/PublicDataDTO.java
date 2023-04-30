package by.ishangulyyev.backend.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublicDataDTO {
    @Email
    @NotBlank
    private String email;

    @Pattern(regexp = "^\\+\\d{1,3}-\\d{1,4}-\\d{1,4}-\\d{1,4}$")
    private String phone;
}
