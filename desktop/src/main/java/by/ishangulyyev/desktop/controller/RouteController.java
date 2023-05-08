package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.Page;
import by.ishangulyyev.desktop.model.PointcutDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class RouteController extends PageController<PointcutDTO> implements AddableButton {

    public RouteController() {
        super("", 4, "id", "");
    }

    @Override
    public void add(ActionEvent event) {

    }

    @Override
    protected List<PointcutDTO> getData(Page dto) {
        return null;
    }

    @Override
    protected void tableAbstractMethod(MouseEvent event, TableView<PointcutDTO> table) {

    }
}
