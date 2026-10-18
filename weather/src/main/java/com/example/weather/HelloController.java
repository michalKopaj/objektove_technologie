package com.example.weather;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class HelloController {

    @FXML
    private Pane pane;
    @FXML
    private Button stopRainButton;

    private final List<WeatherObject> objects = new ArrayList<>();
    private final Random random = new Random();
    private boolean rainStopped = false;

    @FXML
    public void initialize() {
        Rectangle clip = new Rectangle();
        clip.widthProperty().bind(pane.widthProperty());
        clip.heightProperty().bind(pane.heightProperty());
        pane.setClip(clip);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        }.start();
    }

    private void update() {
        double w = pane.getWidth();
        double h = pane.getHeight();

        Iterator<WeatherObject> it = objects.iterator();
        while (it.hasNext()) {
            WeatherObject o = it.next();

            if (!(rainStopped && o instanceof Raindrop)) {
                o.move(w, h);
            }
            if (o.isOutside(w, h)) {
                pane.getChildren().remove(o.getNode());
                it.remove();
            }
        }
    }

    private void add(WeatherObject o) {
        objects.add(o);
        pane.getChildren().add(o.getNode());
    }

    @FXML
    private void onAddCloud() {
        add(new Cloud(random.nextDouble() * pane.getWidth(), 10 + random.nextDouble() * 50));
    }

    @FXML
    private void onAddRaindrop() {
        add(new Raindrop(random.nextDouble() * pane.getWidth(), random.nextDouble() * pane.getHeight()));
    }

    @FXML
    private void onAddSnowflake() {
        add(new Snowflake(random.nextDouble() * pane.getWidth(), random.nextDouble() * pane.getHeight()));
    }

    @FXML
    private void onToggleRain() {
        rainStopped = !rainStopped;
        stopRainButton.setText(rainStopped ? "Spustiť dážď" : "Zastaviť dážď");
    }

    @FXML
    private void onBlueClouds() {
        for (WeatherObject o : objects) {
            if (o instanceof Cloud c) {
                c.setColor(Color.BLUE);
            }
        }
    }

    @FXML
    private void onMoveLeft() {
        for (WeatherObject o : objects) {
            o.moveLeft(20);
        }
    }
}