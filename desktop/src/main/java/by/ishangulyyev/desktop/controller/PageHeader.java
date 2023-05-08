package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public interface PageHeader {
    @FXML
    default void cargo(ActionEvent event) {
        SceneUtil.switchScene(event, "cargos.fxml");
    }
    @FXML
    default void employee(ActionEvent event) {
        SceneUtil.switchScene(event, "employees.fxml");
    }
    @FXML
    default void route(ActionEvent event) {
        SceneUtil.switchScene(event, "routes.fxml");
    }
    @FXML
    default void statistic(ActionEvent event) {
        SceneUtil.switchScene(event, "statistics.fxml");
    }

    @FXML
    default void report(ActionEvent event) {
        SceneUtil.switchScene(event, "reports.fxml");
    }
}
