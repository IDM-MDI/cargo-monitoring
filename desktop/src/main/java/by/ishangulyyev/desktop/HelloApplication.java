package by.ishangulyyev.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("authentication.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Inter:wght@500;600&display=swap");
        scene.getStylesheets().add("/by/ishangulyyev/desktop/application.css");
        stage.getIcons().add(new Image("icon.png"));
        stage.setResizable(false);
        stage.setTitle("Cargo monitoring");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}