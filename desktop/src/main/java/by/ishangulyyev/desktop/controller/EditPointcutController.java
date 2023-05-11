package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.PointcutDTO;
import by.ishangulyyev.desktop.service.impl.RestApi;
import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static by.ishangulyyev.desktop.controller.PointcutController.POINTCUT_PAGE_URL;

public class EditPointcutController implements AcceptButton, BackButton, DeleteButton {
    private final RestApi<PointcutDTO> restApi;
    private PointcutDTO pointcut;
    @FXML
    private TextField loginField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField orderField;

    public void setContent(PointcutDTO pointcut) {
        this.pointcut = pointcut;
        setFields(pointcut);
    }

    public EditPointcutController() {
        this.restApi = new RestApi<>();
    }

    @Override
    public void accept(ActionEvent event) {
        this.pointcut = restApi.patch(POINTCUT_PAGE_URL, pointcut.getId(), "login=" + loginField.getText(), PointcutDTO.class);
        setFields(pointcut);
    }

    @Override
    public void onBackClick(MouseEvent event) {
        SceneUtil.switchScene(event, "routes.fxml");
    }

    @Override
    public void delete(ActionEvent event) {
        restApi.delete(POINTCUT_PAGE_URL, pointcut.getId());
        SceneUtil.switchScene(event, "routes.fxml");
    }

    private void setFields(PointcutDTO pointcut) {
        loginField.setText(pointcut.getLogin());
        nameField.setText(pointcut.getName());
        orderField.setText(String.valueOf(pointcut.getNumber()));
    }
}
