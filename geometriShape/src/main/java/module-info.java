module com.example.geometrishape {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.geometrishape to javafx.fxml;
    exports com.example.geometrishape;
}