package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.Page;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class StatisticController extends PageController<Void> {
    public StatisticController() {
        super("", 4, "", "");
    }

    @Override
    protected List<Void> getData(Page dto) {
        return null;
    }

    @Override
    protected void tableAbstractMethod(MouseEvent event, TableView<Void> table) {

    }
}
