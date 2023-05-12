package by.ishangulyyev.backend.validator;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

@UtilityClass
public class JwtValidator {
    public static boolean isHeaderBearerExist(String header) {
        return Objects.nonNull(header) && header.startsWith("Bearer ");
    }

    public static boolean isUsernameExist(String username) {
        return Objects.nonNull(username) && isSecurityAuthenticationEmpty();
    }

    public static boolean isSecurityAuthenticationEmpty() {
        return isSecurityContextEmpty() || Objects.isNull(SecurityContextHolder.getContext().getAuthentication());
    }

    public static boolean isSecurityContextEmpty() {
        return Objects.isNull(SecurityContextHolder.getContext());
    }
}
