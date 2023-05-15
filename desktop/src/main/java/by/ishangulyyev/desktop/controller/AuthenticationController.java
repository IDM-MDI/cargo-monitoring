package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.Authentication;
import by.ishangulyyev.desktop.service.AuthenticationService;
import by.ishangulyyev.desktop.service.impl.AuthenticationServiceImpl;
import by.ishangulyyev.desktop.service.impl.RestApi;
import by.ishangulyyev.desktop.util.AlertUtil;
import by.ishangulyyev.desktop.util.AuthenticationPropertiesUtil;
import by.ishangulyyev.desktop.util.SceneUtil;
import by.ishangulyyev.desktop.validator.AuthenticationValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthenticationController {
    private final AuthenticationService service;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;

    public AuthenticationController() {
        this.service = new AuthenticationServiceImpl();
    }

    @FXML
    public void submit(ActionEvent event) {
        service.submit(event,Authentication.builder()
                .login(loginField.getText())
                .password(passwordField.getText())
                .build());
    }
}
