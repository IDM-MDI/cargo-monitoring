package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.Page;
import by.ishangulyyev.desktop.service.WebFetch;
import by.ishangulyyev.desktop.service.impl.RestApiFetch;
import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.List;

public abstract class PageController<T> {
    protected final WebFetch<T> webFetch;
    protected Page page;
    protected final String url;
    protected final int size;
    protected final String filter;
    protected final String direction;
    @FXML
    private Text leftArrow;
    @FXML
    private Text rightArrow;
    @FXML
    private Text pageNumber;
    @FXML
    private TableView<T> table;

    protected PageController(String url, int size, String filter, String direction) {
        this.url = url;
        this.size = size;
        this.filter = filter;
        this.direction = direction;
        this.webFetch = new RestApiFetch<>();
    }
    @FXML
    public void onLeftArrowClick(MouseEvent event) {
        int integerText = Integer.parseInt(pageNumber.getText()) - 1;
        setTable(integerText - 1);
        pageNumber.setText(String.valueOf(integerText));
    }

    @FXML
    public void onRightArrowClick(MouseEvent event) {
        int integerText = Integer.parseInt(pageNumber.getText()) - 1;
        setTable(integerText + 1);
        pageNumber.setText(String.valueOf(integerText + 2));
    }

    @FXML
    public void onReloadClick(MouseEvent event) {
        setTable(Integer.parseInt(pageNumber.getText()) - 1);
    }

    @FXML
    public void tableClicked(MouseEvent event) {
        if(event.getClickCount() < 2) {
            return;
        }
        tableAbstractMethod(event,table);
    }
    @FXML
    public void cargo(ActionEvent event) {
        SceneUtil.switchScene(event, "cargos.fxml");
    }
    @FXML
    public void employee(ActionEvent event) {
        SceneUtil.switchScene(event, "employees.fxml");
    }
    @FXML
    public void route(ActionEvent event) {
        SceneUtil.switchScene(event, "routes.fxml");
    }
    @FXML
    public void statistic(ActionEvent event) {
        SceneUtil.switchScene(event, "statistics.fxml");
    }

    @FXML
    public void report(ActionEvent event) {
        SceneUtil.switchScene(event, "reports.fxml");
    }

    protected Page fetchData(int page) {
        return webFetch.getDTO(url, page, size, filter, direction);
    }


    protected void setTable(int page) {
        setTable(fetchData(page));
    }

    protected void setTable(Page page) {
        this.page = page;
        setLeftArrow();
        setRightArrow();
        table.setItems(FXCollections.observableList(getData(page)));
    }
    private void setLeftArrow() {
        if(page.isFirst()) {
            leftArrow.setDisable(true);
            leftArrow.setVisible(false);
        } else {
            leftArrow.setDisable(false);
            leftArrow.setVisible(true);
        }
    }

    private void setRightArrow() {
        if(page.isLast()) {
            rightArrow.setDisable(true);
            rightArrow.setVisible(false);
        } else {
            rightArrow.setDisable(false);
            rightArrow.setVisible(true);
        }
    }
    protected abstract List<T> getData(Page dto);
    protected abstract void tableAbstractMethod(MouseEvent event, TableView<T> table);
}
