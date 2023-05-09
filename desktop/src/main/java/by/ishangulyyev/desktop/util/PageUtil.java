package by.ishangulyyev.desktop.util;

import by.ishangulyyev.desktop.model.Page;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import lombok.experimental.UtilityClass;

import java.util.function.Predicate;

@UtilityClass
public class PageUtil {
    public void setArrows(Page page, Text left, Text right) {
        setArrow(page, Page::isFirst, left);
        setArrow(page, Page::isLast, right);
    }
    public void setDisableNonEditable(TextField field) {
        field.setDisable(true);
        field.setVisible(true);
        field.setEditable(false);
    }
    public void setEditable(TextField field) {
        field.setDisable(false);
        field.setVisible(true);
        field.setEditable(true);
    }
    public void setInvisible(HBox box) {
        box.setDisable(true);
        box.setVisible(false);
    }
    public void setVisible(HBox box) {
        box.setDisable(false);
        box.setVisible(true);
    }
    private void setArrow(Page page, Predicate<Page> predicate, Text arrow) {
        if(predicate.test(page)) {
            arrow.setDisable(true);
            arrow.setVisible(false);
        } else {
            arrow.setDisable(false);
            arrow.setVisible(true);
        }
    }
}
