module com.example.weather {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.weather to javafx.fxml;
    exports com.example.weather;
}