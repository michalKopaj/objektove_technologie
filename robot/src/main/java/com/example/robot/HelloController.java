package com.example.robot;

import javafx.fxml.FXML;

import javafx.application.Platform;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Pane root;

    private Robot robot;

    @FXML
    protected void initialize() {
        robot=new Robot(10,10);
        root.getChildren().add(robot);
        Platform.runLater(() -> robot.requestFocus());
    }
}
