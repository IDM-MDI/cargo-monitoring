package by.ishangulyyev.desktop.util;

import by.ishangulyyev.desktop.model.Page;
import javafx.scene.text.Text;
import lombok.experimental.UtilityClass;

import java.util.function.Predicate;

@UtilityClass
public class PageUtil {
    public void setArrows(Page page, Text left, Text right) {
        setArrow(page, Page::isFirst, left);
        setArrow(page, Page::isLast, right);
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
