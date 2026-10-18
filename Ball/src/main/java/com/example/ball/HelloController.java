package com.example.ball;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HelloController {

    @FXML
    private Pane pane;

    private Ball ball;

    @FXML
    public void initialize() {
        ball = new Ball(pane, 25, Color.CORNFLOWERBLUE);
        pane.getChildren().add(ball);
        ball.start();


        pane.sceneProperty().addListener((obs, oldScene, scene) -> {
            if (scene != null) {
                scene.setOnKeyPressed(e -> {
                    switch (e.getCode()) {
                        case F -> ball.faster();
                        case S -> ball.slower();
                        default -> { }
                    }
                });
            }
        });
    }
}