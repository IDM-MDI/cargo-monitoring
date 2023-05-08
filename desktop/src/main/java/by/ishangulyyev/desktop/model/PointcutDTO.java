package by.ishangulyyev.desktop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PointcutDTO {
    private String id;
    private String name;
    private Long number;
    private String login;
}
