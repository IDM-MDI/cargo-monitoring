package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class CargoByIDController extends CargoByIDNavigation {

    @Override
    public void delete(ActionEvent event) {

    }

    @Override
    public void edit(ActionEvent event) {
        if(isEdit) {
            isEdit = false;
        } else {
            isEdit = true;
            setEditableFields();
        }
    }

    @FXML
    public void onBackClick(MouseEvent event) {
        SceneUtil.switchScene(event, "cargos.fxml");
    }
}
