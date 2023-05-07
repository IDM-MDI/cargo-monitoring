module by.ishangulyyev.desktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens by.ishangulyyev.desktop to javafx.fxml;
    exports by.ishangulyyev.desktop;
    exports by.ishangulyyev.desktop.controller;
    opens by.ishangulyyev.desktop.controller to javafx.fxml;
}