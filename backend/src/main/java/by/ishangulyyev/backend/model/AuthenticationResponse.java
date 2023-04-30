package by.ishangulyyev.backend.model;

import by.ishangulyyev.backend.entity.type.AuthenticationRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String login;
    private AuthenticationRole role;
    private String token;
}
