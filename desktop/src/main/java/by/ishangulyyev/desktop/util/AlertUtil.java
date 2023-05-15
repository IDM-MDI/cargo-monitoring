package by.ishangulyyev.desktop.util;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import lombok.experimental.UtilityClass;
import org.kordamp.bootstrapfx.BootstrapFX;

@UtilityClass
public class AlertUtil {
    public static void infoMessage(String title, String message) {
        alertMessage(Alert.AlertType.INFORMATION, title, message, "alert-info");
    }
    public static void errorMessage(String title, String message) {
        alertMessage(Alert.AlertType.ERROR, title, message, "alert-danger");
    }
    public static void warningMessage(String title, String message) {
        alertMessage(Alert.AlertType.WARNING, title, message, "alert-warning");
    }
    public static void successMessage(String title, String message) {
        alertMessage(Alert.AlertType.CONFIRMATION, title, message, "alert-success");
    }
    public static void alertMessage(Alert.AlertType alertType, String title, String message, String css) {
        Alert alert = new Alert(alertType);
        alert.getDialogPane().getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        alert.getDialogPane().getStylesheets().add("/by/ishangulyyev/desktop/application.css");
        alert.getDialogPane().getStyleClass().add(css);
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.getStyleClass().add("btn-default");
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
