package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.Authentication;
import by.ishangulyyev.desktop.service.impl.RestApi;
import by.ishangulyyev.desktop.util.AlertUtil;
import by.ishangulyyev.desktop.util.AuthenticationPropertiesUtil;
import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthenticationController {
    private static final String AUTHENTICATION_URL = "http://localhost:8080/api/v1/user/login";
    private final RestApi<Authentication> restApi;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;

    public AuthenticationController() {
        this.restApi = new RestApi<>();
    }

    @FXML
    public void submit(ActionEvent event) {
        Authentication authentication = restApi.post(
                AUTHENTICATION_URL,
                Authentication.builder()
                        .login(loginField.getText())
                        .password(passwordField.getText())
                        .build(),
                Authentication.class
        );
        AuthenticationPropertiesUtil.setProperties("login", authentication.getLogin());
        AuthenticationPropertiesUtil.setProperties("token", authentication.getToken());
        AlertUtil.successMessage("Authorized", "You have been successfully authorized");
        SceneUtil.switchScene(event, "employees.fxml");
    }
}
