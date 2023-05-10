package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.Page;
import by.ishangulyyev.desktop.model.PointcutDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RouteController extends PageController<PointcutDTO> implements AddButton, Initializable {
    public static final String POINTCUT_PAGE_URL = "http://localhost:8080/api/v1/pointcuts";
    private static final int SIZE = 15;
    private static final String FILTER = "id";
    private static final String DIRECTION = "asc";
    @FXML
    private TableColumn<PointcutDTO, String> nameColumn;
    @FXML
    private TableColumn<PointcutDTO, Long> orderColumn;
    @FXML
    private TableColumn<PointcutDTO, String> loginColumn;
    public RouteController() {
        super(POINTCUT_PAGE_URL, SIZE, FILTER, DIRECTION);
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
        restApi.delete(POINTCUT_PAGE_URL, table.getSelectionModel().getSelectedItem().getId());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        orderColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        setTable(0);
    }
}
