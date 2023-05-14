package by.ishangulyyev.desktop.button;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public interface BackButton {
    @FXML
    void onBackClick(MouseEvent event);
}
