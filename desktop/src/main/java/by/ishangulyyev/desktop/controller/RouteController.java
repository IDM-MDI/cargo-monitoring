package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.Page;
import by.ishangulyyev.desktop.model.PointcutDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class RouteController extends PageController<PointcutDTO> implements AddableButton {
    private static final String PAGE_URL = "http://localhost:8080/api/v1/pointcuts";
    private static final int SIZE = 15;
    private static final String FILTER = "id";
    private static final String DIRECTION = "asc";
    public RouteController() {
        super(PAGE_URL, SIZE, FILTER, DIRECTION);
    }

    @Override
    public void add(ActionEvent event) {

    }

    @Override
    protected List<PointcutDTO> getData(Page dto) {
        return dto.getContent()
                .stream()
                .map(tree ->
                        PointcutDTO.builder()
                                .id(tree.get("id"))
                                .name(tree.get("name"))
                                .number(Long.parseLong(tree.get("number")))
                                .login(tree.get("login"))
                                .build()
                )
                .toList();
    }

    @Override
    protected void tableClicked(MouseEvent event, TableView<PointcutDTO> table) {

    }
}
