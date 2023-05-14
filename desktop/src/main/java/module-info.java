module by.ishangulyyev.desktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires org.kordamp.bootstrapfx.core;
    requires static lombok;


    opens by.ishangulyyev.desktop to javafx.fxml;
    opens by.ishangulyyev.desktop.model to com.google.gson;
    opens by.ishangulyyev.desktop.service to com.google.gson;
    opens by.ishangulyyev.desktop.controller to javafx.fxml;
    opens by.ishangulyyev.desktop.util to org.kordamp.bootstrapfx.core;

    exports by.ishangulyyev.desktop;
    exports by.ishangulyyev.desktop.model;
    exports by.ishangulyyev.desktop.service;
    exports by.ishangulyyev.desktop.service.impl;
    exports by.ishangulyyev.desktop.controller;
    exports by.ishangulyyev.desktop.util;
}