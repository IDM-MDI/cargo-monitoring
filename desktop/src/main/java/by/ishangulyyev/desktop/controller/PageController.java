package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.Page;
import by.ishangulyyev.desktop.service.WebFetch;
import by.ishangulyyev.desktop.service.impl.RestApiFetch;
import by.ishangulyyev.desktop.util.PageUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.List;

public abstract class PageController<T> implements PageHeader {
    private final WebFetch<T> webFetch;
    private final String url;
    private final int size;
    private final String filter;
    private final String direction;
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
        tableClicked(event,table);
    }
    protected void setTable(int page) {
        setTable(webFetch.getDTO(url, page, size, filter, direction));
    }

    protected void setTable(Page page) {
        PageUtil.setArrows(page, leftArrow, rightArrow);
        table.setItems(FXCollections.observableList(getData(page)));
    }
    protected abstract List<T> getData(Page dto);
    protected abstract void tableClicked(MouseEvent event, TableView<T> table);
}
