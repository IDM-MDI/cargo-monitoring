package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.Authentication;
import by.ishangulyyev.desktop.service.AuthenticationService;
import by.ishangulyyev.desktop.service.impl.AuthenticationServiceImpl;
import by.ishangulyyev.desktop.util.AlertUtil;
import by.ishangulyyev.desktop.util.IPUtil;
import by.ishangulyyev.desktop.util.PropertiesUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class AuthenticationController implements Initializable {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Objects.nonNull(PropertiesUtil.getPropertyValue("ip"))) {
            return;
        }
        while(true) {
            Optional<String> ip = IPUtil.findIP(8080);
            if(ip.isPresent()) {
                PropertiesUtil.setProperties("ip",ip.get());
                break;
            } else {
                AlertUtil.errorMessage("IP NOT FOUND", "Ip not found after scan, try again?");
            }
        }
    }
}
