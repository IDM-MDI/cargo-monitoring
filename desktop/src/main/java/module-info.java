module by.ishangulyyev.desktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires static lombok;


    opens by.ishangulyyev.desktop to javafx.fxml;
    opens by.ishangulyyev.desktop.model to com.google.gson;
    opens by.ishangulyyev.desktop.service.impl to com.google.gson;
    opens by.ishangulyyev.desktop.controller to javafx.fxml;

    exports by.ishangulyyev.desktop;
    exports by.ishangulyyev.desktop.model;
    exports by.ishangulyyev.desktop.service;
    exports by.ishangulyyev.desktop.controller;
}