package by.ishangulyyev.desktop.service;

import by.ishangulyyev.desktop.model.Authentication;
import by.ishangulyyev.desktop.util.AlertUtil;
import by.ishangulyyev.desktop.util.PropertiesUtil;
import by.ishangulyyev.desktop.util.SceneUtil;
import by.ishangulyyev.desktop.validator.AuthenticationValidator;
import javafx.event.ActionEvent;

public interface AuthenticationService {
    void submit(ActionEvent event, String login, String password);
    static Authentication getAuthentication(String login, String password) {
        if(!AuthenticationValidator.isLoginValid(login)) {
            AlertUtil.errorMessage("Login not valid", "Login must be not empty and length between 2 and 50");
            throw new RuntimeException("Login not valid");
        } else if(!AuthenticationValidator.isPasswordValid(password)) {
            AlertUtil.errorMessage("Password not valid", "Password must be not empty and length between 2 and 50");
            throw new RuntimeException("Password not valid");
        }
        return Authentication.builder()
                .login(login)
                .password(password)
                .build();
    }
    static void switchAfterAuthenticate(ActionEvent event) {
        AlertUtil.successMessage("Authorized", "You have been successfully authorized");
        SceneUtil.switchScene(event, "employees.fxml");
    }

    static void save(Authentication result) {
        PropertiesUtil.setProperties("login", result.getLogin());
        PropertiesUtil.setProperties("token", result.getToken());
    }

    static void adminChecker(String role) {
        if(!"ADMIN".equals(role)) {
            AlertUtil.errorMessage("Not admin", "You're not administrator");
            throw new RuntimeException("Not admin");
        }
    }
}
