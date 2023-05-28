package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.Page;
import by.ishangulyyev.desktop.model.Report;
import by.ishangulyyev.desktop.util.SceneUtil;
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

public class ReportController extends PageController<Report> implements Initializable {
    public static final String REPORT_PAGE_URL = "/api/v1/cargos/decline";
    private static final int SIZE = 15;
    private static final String FILTER = "id";
    private static final String DIRECTION = "asc";

    @FXML
    private TableColumn<Report, String> id;
    @FXML
    private TableColumn<Report, String> name;
    @FXML
    private TableColumn<Report, String> surname;
    @FXML
    private TableColumn<Report, String> cargo;
    @FXML
    private TableColumn<Report, String> pointcut;

    public ReportController() {
        super(REPORT_PAGE_URL, SIZE, FILTER, DIRECTION);
    }

    @Override
    protected List<Report> getData(Page dto) {
        return dto.getContent()
                .stream()
                .map(tree ->
                        Report.builder()
                                .id(tree.get("id"))
                                .name(tree.get("name"))
                                .surname(tree.get("surname"))
                                .pointcut(tree.get("pointcut"))
                                .cargoID(tree.get("cargoID"))
                                .build()
                )
                .toList();
    }

    @Override
    protected void tableClicked(MouseEvent event, TableView<Report> table) {
        Consumer<CargoByIDController> consumer = controller -> controller.setInitial(table.getSelectionModel().getSelectedItem().getCargoID());
        SceneUtil.switchScene(event, "cargo-by-id-main.fxml", consumer);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        pointcut.setCellValueFactory(new PropertyValueFactory<>("pointcut"));
        cargo.setCellValueFactory(new PropertyValueFactory<>("cargoID"));
        setTable(0);
    }
}
