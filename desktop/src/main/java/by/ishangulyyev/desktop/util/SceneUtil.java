package by.ishangulyyev.desktop.util;


import by.ishangulyyev.desktop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SceneUtil {
    @SneakyThrows
    public static void switchScene(ActionEvent event, String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }
}
