package by.ishangulyyev.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    private String id;
    private String name;
    private String originName;
    private PublicDataDTO publicData;
}
