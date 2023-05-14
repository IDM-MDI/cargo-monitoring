package by.ishangulyyev.desktop.util;


import by.ishangulyyev.desktop.HelloApplication;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.util.function.Consumer;

@UtilityClass
public class SceneUtil {
    @SneakyThrows
    public static void switchScene(Event event, String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Stage stage = getStage(event);
        stage.setScene(getScene(fxmlLoader));
        stage.show();
    }

    @SneakyThrows
    public static <T> void switchScene(Event event, String fxml, Consumer<T> consumer) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Stage stage = getStage(event);
        stage.setScene(getScene(fxmlLoader));
        consumer.accept(fxmlLoader.getController());
        stage.show();
    }

    public static Stage getStage(Event event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    private Scene getScene(FXMLLoader loader) throws IOException {
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add("/by/ishangulyyev/desktop/application.css");
        return scene;
    }
}
