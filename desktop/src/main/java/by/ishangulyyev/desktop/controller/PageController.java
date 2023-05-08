package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.service.WebFetch;
import by.ishangulyyev.desktop.service.impl.RestApiFetch;
import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public abstract class PageController<T> {
    protected final WebFetch<T> webFetch;

    protected PageController() {
        this.webFetch = new RestApiFetch<>();
    }

    @FXML
    public void cargo(ActionEvent event) {
        SceneUtil.switchScene(event, "cargos.fxml");
    }
    @FXML
    public void employee(ActionEvent event) {
        SceneUtil.switchScene(event, "employees.fxml");
    }
    @FXML
    public void route(ActionEvent event) {
        SceneUtil.switchScene(event, "routes.fxml");
    }
    @FXML
    public void statistic(ActionEvent event) {
        SceneUtil.switchScene(event, "statistics.fxml");
    }
    @FXML
    public void report(ActionEvent event) {
        SceneUtil.switchScene(event, "reports.fxml");
    }
}
