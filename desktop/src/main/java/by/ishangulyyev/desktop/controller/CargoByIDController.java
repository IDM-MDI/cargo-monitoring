package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.Cargo;
import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import static by.ishangulyyev.desktop.controller.CargoController.CARGO_PAGE_URL;

public class CargoByIDController extends CargoByIDNavigation {

    @Override
    public void delete(ActionEvent event) {
        if(restApi.delete(CARGO_PAGE_URL, cargo.getId()) == 200) {
            SceneUtil.switchScene(event, "cargos.fxml");
        }
    }

    @Override
    public void edit(ActionEvent event) {
        if(isEdit) {
            isEdit = false;
            super.cargo = restApi.put(CARGO_PAGE_URL, cargo.getId(), cargo, Cargo.class);
            setEditableFields();
            setFields();
        } else {
            isEdit = true;
            setEditableFields();
        }
    }

    @FXML
    public void onBackClick(MouseEvent event) {
        SceneUtil.switchScene(event, "cargos.fxml");
    }

    @Override
    public void accept(ActionEvent event) {
        // TODO: 5/13/2023 accept
    }
    @FXML
    public void decline(ActionEvent event) {
        // TODO: 5/13/2023 decline
    }
}
