module org.custom.items {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.custom.items to javafx.fxml;
    exports org.custom.items;
}
