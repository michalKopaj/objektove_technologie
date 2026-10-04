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
    private void initialize() {
        jednotka.getItems().addAll("mm", "cm", "m", "km");
        jednotka.setValue("m");
    }


    @FXML
    protected void prepocitaj() {
        try {
            double hodnota = Double.parseDouble(vstup.getText().trim().replace(',', '.'));
            double metre = hodnota * faktor(jednotka.getValue());
            vystupMm.setText(format(metre * 1000));
            vystupCm.setText(format(metre * 100));
            vystupM.setText(format(metre));
            vystupKm.setText(format(metre / 1000));
            chyba.setText("");
        } catch (NumberFormatException e) {
            chyba.setText("Zadajte platné číslo");
        }
    }
    private double faktor(String j) {
        return switch (j) {
            case "mm" -> 0.001;
            case "cm" -> 0.01;
            case "km" -> 1000;
            default -> 1;
        };
    }