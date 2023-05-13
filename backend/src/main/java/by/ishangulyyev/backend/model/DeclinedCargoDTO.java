package by.ishangulyyev.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeclinedCargoDTO {
    private String id;
    private String name;
    private String surname;
    private String pointcut;
    private String cargoID;
}
