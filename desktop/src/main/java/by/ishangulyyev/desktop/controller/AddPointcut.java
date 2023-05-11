package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.PointcutDTO;
import by.ishangulyyev.desktop.service.impl.RestApi;
import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static by.ishangulyyev.desktop.controller.PointcutController.POINTCUT_PAGE_URL;

public class AddPointcut implements AcceptButton, BackButton {
    private final RestApi<PointcutDTO> restApi;
    @FXML
    private TextField loginField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField orderField;

    public AddPointcut() {
        restApi = new RestApi<>();
    }

    @Override
    public void accept(ActionEvent event) {
        restApi.post(POINTCUT_PAGE_URL,
                PointcutDTO.builder()
                        .name(nameField.getText())
                        .login(loginField.getText())
                        .number(Long.parseLong(orderField.getText()))
                        .build(),
                PointcutDTO.class);
        SceneUtil.switchScene(event, "routes.fxml");
    }

    @Override
    public void onBackClick(MouseEvent event) {
        SceneUtil.switchScene(event, "routes.fxml");
    }
}
