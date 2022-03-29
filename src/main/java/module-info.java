module com.asa.asagui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.asa.asagui to javafx.fxml;
    exports com.asa.asagui;
    exports com.asa.launcher;
    opens com.asa.launcher to javafx.fxml;
}