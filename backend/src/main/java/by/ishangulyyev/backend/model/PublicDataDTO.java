package by.ishangulyyev.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublicDataDTO {
    private Long id;
    private String phone;
    private String email;
}
