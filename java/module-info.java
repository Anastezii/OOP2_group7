module bg.tu_varna.sit.carrent {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires log4j;
    requires org.hibernate.orm.core;
    requires java.persistence;

    requires java.naming;
    requires java.sql;
     requires mysql.connector.java;
    requires lombok;


    opens bg.tu_varna.sit.carrent.data.entities to org.hibernate.orm.core;
    exports bg.tu_varna.sit.carrent.data.entities;

    opens bg.tu_varna.sit.carrent.data.access to org.hibernate.orm.core;
    exports bg.tu_varna.sit.carrent.data.access;

    exports bg.tu_varna.sit.carrent.application;
    opens bg.tu_varna.sit.carrent.application to javafx.fxml;

    exports bg.tu_varna.sit.carrent.presentation.controlers;
    opens bg.tu_varna.sit.carrent.presentation.controlers to javafx.fxml;
}