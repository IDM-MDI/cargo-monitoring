package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.button.AddButton;
import by.ishangulyyev.desktop.model.EmployeePage;
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


public class EmployeeController extends PageController<EmployeePage> implements Initializable, AddButton {
    public static final String EMPLOYEE_PAGE_URL = "/api/v1/employees";
    private static final int SIZE = 15;
    private static final String FILTER = "id";
    private static final String DIRECTION = "asc";

    @FXML
    private TableColumn<EmployeePage, String> idColumn;
    @FXML
    private TableColumn<EmployeePage, String> nameColumn;
    @FXML
    private TableColumn<EmployeePage, String> surnameColumn;
    @FXML
    private TableColumn<EmployeePage, String> positionColumn;
    @FXML
    private TableColumn<EmployeePage, String> statusColumn;

    public EmployeeController() {
        super(EMPLOYEE_PAGE_URL, SIZE, FILTER, DIRECTION);
    }

    @Override
    public void add(ActionEvent event) {
        SceneUtil.switchScene(event, "add-employee.fxml");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        setTable(0);
    }

    @Override
    protected List<EmployeePage> getData(Page dto) {
        return dto.getContent()
                .stream()
                .map(tree ->
                        EmployeePage.builder()
                                .id(tree.get("id"))
                                .name(tree.get("name"))
                                .surname(tree.get("surname"))
                                .position(tree.get("position"))
                                .status(tree.get("status"))
                                .build()
                )
                .toList();
    }

    @Override
    protected void tableClicked(MouseEvent event, TableView<EmployeePage> table) {
        Consumer<EmployeeByIDController> consumer = controller -> controller.setId(table.getSelectionModel().getSelectedItem());
        SceneUtil.switchScene(event, "employee-by-id.fxml", consumer);
    }
}