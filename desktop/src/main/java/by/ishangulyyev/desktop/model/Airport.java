package by.ishangulyyev.desktop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Airport {
    private String id;
    private String name;
    private Company company;
    private Origin origin;
}
