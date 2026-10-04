module com.example.prevod_jednotiek {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prevod_jednotiek to javafx.fxml;
    exports com.example.prevod_jednotiek;
}