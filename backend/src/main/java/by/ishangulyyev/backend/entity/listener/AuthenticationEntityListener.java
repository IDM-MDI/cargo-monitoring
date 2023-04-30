package by.ishangulyyev.backend.entity.listener;

import by.ishangulyyev.backend.entity.Authentication;
import by.ishangulyyev.backend.entity.type.AuthenticationRole;
import jakarta.persistence.PrePersist;

public class AuthenticationEntityListener {
    @PrePersist
    public void setCreationDate(Authentication entity) {
        entity.setRole(AuthenticationRole.USER);
    }
}
