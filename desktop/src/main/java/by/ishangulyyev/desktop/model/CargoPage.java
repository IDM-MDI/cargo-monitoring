package by.ishangulyyev.desktop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoPage {
    private String id;
    private String client;
    private String country;
    private String type;
    private String status;
}
