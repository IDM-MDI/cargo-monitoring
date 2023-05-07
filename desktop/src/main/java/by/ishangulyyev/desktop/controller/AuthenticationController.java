package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthenticationController {
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;

    @FXML
    public void submit(ActionEvent event) {
        SceneUtil.switchScene(event, "employees.fxml");
    }
}
