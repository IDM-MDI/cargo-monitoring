package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public abstract class CargoByIDNavigation {
    @FXML
    protected void main(ActionEvent event) {
        SceneUtil.switchScene(event, "cargo-by-id-main.fxml");
    }
    @FXML
    protected void client(ActionEvent event) {
        SceneUtil.switchScene(event, "cargo-by-id-client.fxml");
    }
    @FXML
    protected void from(ActionEvent event) {
        SceneUtil.switchScene(event, "cargo-by-id-from.fxml");
    }
    @FXML
    protected void departure(ActionEvent event) {
        SceneUtil.switchScene(event, "cargo-by-id-departure.fxml");
    }
    @FXML
    protected void parameters(ActionEvent event) {
        SceneUtil.switchScene(event, "cargo-by-id-parameters.fxml");
    }
}
