package com.example.geometrishape;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load()); // bez pevnej veľkosti, okno sa prispôsobí obsahu
        stage.setTitle("Geometric shapes");
        stage.setScene(scene);
        stage.show();
    }
}
