package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public abstract class PageHeader {
    @FXML
    protected void cargo(ActionEvent event) {
        SceneUtil.switchScene(event, "cargos.fxml");
    }
    @FXML
    protected void employee(ActionEvent event) {
        SceneUtil.switchScene(event, "employees.fxml");
    }
    @FXML
    protected void route(ActionEvent event) {
        SceneUtil.switchScene(event, "routes.fxml");
    }
    @FXML
    protected void statistic(ActionEvent event) {
        SceneUtil.switchScene(event, "statistics.fxml");
    }

    @FXML
    protected void report(ActionEvent event) {
        SceneUtil.switchScene(event, "reports.fxml");
    }
}
