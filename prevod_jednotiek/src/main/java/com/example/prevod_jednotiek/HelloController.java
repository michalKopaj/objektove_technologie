package com.example.prevod_jednotiek;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class HelloController {
    @FXML private TextField vstup,vystupMm,vystupCm,vystupM,vystupKm;
    @FXML private ComboBox <String> jednotka;
    @FXML private label chyba;
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
