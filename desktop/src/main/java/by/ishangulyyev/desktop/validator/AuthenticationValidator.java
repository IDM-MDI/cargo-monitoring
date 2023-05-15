package by.ishangulyyev.desktop.validator;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthenticationValidator {
    public boolean isLoginValid(@NonNull String login) {
        return !login.isBlank() && login.length() >= 2 && login.length() <= 50;
    }
    public boolean isPasswordValid(@NonNull String password) {
        return !password.isBlank() && password.length() >= 2 && password.length() <= 50;
    }
}
