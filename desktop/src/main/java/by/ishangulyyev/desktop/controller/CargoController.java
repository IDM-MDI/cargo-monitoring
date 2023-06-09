package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.button.AddButton;
import by.ishangulyyev.desktop.model.CargoPage;
import by.ishangulyyev.desktop.model.Page;
import by.ishangulyyev.desktop.util.SceneUtil;
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
import java.util.function.Consumer;

public class CargoController extends PageController<CargoPage> implements AddButton, Initializable {
    public static final String CARGO_PAGE_URL = "/api/v1/cargos";
    private static final int SIZE = 15;
    private static final String FILTER = "id";
    private static final String DIRECTION = "asc";
    @FXML
    private TableColumn<CargoPage, String> idColumn;
    @FXML
    private TableColumn<CargoPage, String> clientColumn;
    @FXML
    private TableColumn<CargoPage, String> countryColumn;
    @FXML
    private TableColumn<CargoPage, String> typeColumn;
    @FXML
    private TableColumn<CargoPage, String> statusColumn;
    public CargoController() {
        super(CARGO_PAGE_URL, SIZE, FILTER, DIRECTION);
    }

    @Override
    public void add(ActionEvent event) {
        SceneUtil.switchScene(event, "add-cargo.fxml");
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
        Consumer<CargoByIDController> consumer = controller -> controller.setInitial(table.getSelectionModel().getSelectedItem().getId());
        SceneUtil.switchScene(event, "cargo-by-id-main.fxml", consumer);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        clientColumn.setCellValueFactory(new PropertyValueFactory<>("client"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        setTable(0);
    }
}
