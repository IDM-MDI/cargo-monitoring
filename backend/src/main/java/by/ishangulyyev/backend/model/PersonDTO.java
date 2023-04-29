package by.ishangulyyev.backend.model;

import by.ishangulyyev.backend.entity.type.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private String id;
    private String name;
    private String surname;
    private String lastname;
    private LocalDate birthday;
    private Gender gender;
    private PublicDataDTO publicData;
}
