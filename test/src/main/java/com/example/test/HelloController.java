package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HelloController {
    @FXML private VBox box;
    @FXML private Button btnRezim, btnKrok, btnVypni;

    private Semafor s;

    @FXML
    private void initialize() {
        s = new Semafor();
        box.getChildren().add(s);
        obnov();
    }

    @FXML protected void onRezim() { s.prepniRezim(); obnov(); }
    @FXML protected void onKrok()  { s.zmenaStavu(); }
    @FXML protected void onVypni() { s.prepniVypnutie(); obnov(); }

    // nastavenie textov a dostupnosti tlačidiel
    private void obnov() {
        btnRezim.setText(s.isAuto() ? "Prepnúť na manuálne" : "Prepnúť na automatické");
        btnRezim.setDisable(s.isVypnuty());
        btnKrok.setDisable(s.isAuto() || s.isVypnuty());
        btnVypni.setText(s.isVypnuty() ? "Oživiť semafor" : "Vypnúť semafor");
    }
}