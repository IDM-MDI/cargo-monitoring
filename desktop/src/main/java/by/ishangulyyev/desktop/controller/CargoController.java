package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.CargoPage;
import by.ishangulyyev.desktop.model.Page;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class CargoController extends PageController<CargoPage> implements AddableButton {
    private static final String CARGO_PAGE_URL = "http://localhost:8080/api/v1/cargos";
    private static final int SIZE = 4;
    private static final String FILTER = "id";
    private static final String DIRECTION = "asc";

    public CargoController() {
        super(CARGO_PAGE_URL, SIZE, FILTER, DIRECTION);
    }

    @Override
    public void add(ActionEvent event) {

    }

    @Override
    protected List<CargoPage> getData(Page dto) {
        return null;
    }

    @Override
    protected void tableAbstractMethod(MouseEvent event, TableView<CargoPage> table) {

    }
}
