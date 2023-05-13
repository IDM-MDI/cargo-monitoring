package by.ishangulyyev.backend.util;

import by.ishangulyyev.backend.exception.UserNotFoundException;
import by.ishangulyyev.backend.validator.JwtValidator;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class ContextUtil {
    public static String getLogin() {
        if(JwtValidator.isSecurityAuthenticationEmpty()) {
            throw new UserNotFoundException();
        }
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
    }
}
