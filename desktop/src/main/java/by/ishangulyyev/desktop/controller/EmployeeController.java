package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.EmployeePage;
import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController extends PageController<EmployeePage> implements Initializable, AddableButton {
    @Override
    public void add(ActionEvent event) {
        SceneUtil.switchScene(event, "add-employee.fxml");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialize");
    }
}