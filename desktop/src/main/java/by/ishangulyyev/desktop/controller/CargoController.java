package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.CargoPage;
import by.ishangulyyev.desktop.model.Page;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class CargoController extends PageController<CargoPage> implements AddableButton {
    private static final String PAGE_URL = "http://localhost:8080/api/v1/cargos";
    private static final int SIZE = 15;
    private static final String FILTER = "id";
    private static final String DIRECTION = "asc";

    public CargoController() {
        super(PAGE_URL, SIZE, FILTER, DIRECTION);
    }

    @Override
    public void add(ActionEvent event) {

    }

    @Override
    protected List<CargoPage> getData(Page dto) {
        return dto.getContent()
                .stream()
                .map(tree ->
                        CargoPage.builder()
                                .id(tree.get("id"))
                                .client(tree.get("client"))
                                .country(tree.get("country"))
                                .type(tree.get("type"))
                                .status(tree.get("status"))
                                .build()
                )
                .toList();
    }

    @Override
    protected void tableClicked(MouseEvent event, TableView<CargoPage> table) {

    }
}
