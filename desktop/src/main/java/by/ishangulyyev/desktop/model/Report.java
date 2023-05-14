package by.ishangulyyev.desktop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private String id;
    private String name;
    private String surname;
    private String pointcut;
    private String cargoID;
}
