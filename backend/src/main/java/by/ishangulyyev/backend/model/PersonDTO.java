package by.ishangulyyev.backend.model;

import by.ishangulyyev.backend.entity.type.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @NotBlank
    @Length(min = 2, max = 50)
    private String name;

    @Length(min = 2, max = 50)
    private String surname;

    @NotBlank
    @Length(min = 2, max = 50)
    private String lastname;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Past
    private LocalDate birthday;

    @NotNull
    private Gender gender;

    @NotNull
    private PublicDataDTO publicData;
}
