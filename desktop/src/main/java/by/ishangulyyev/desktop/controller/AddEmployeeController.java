package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddEmployeeController {
    @FXML
    public void back(ActionEvent event) {
        SceneUtil.switchScene(event, "employees.fxml");
    }
}
