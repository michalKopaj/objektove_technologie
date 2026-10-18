package com.example.animal;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML private Canvas canvas;
    @FXML private Button btnStop;

    private GraphicsContext gc;
    private final List<Animal> animals = new ArrayList<>();
    private boolean running = true;

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (running) {
                    for (Animal a : animals) a.move();
                }

                double w = canvas.getWidth(), h = canvas.getHeight();
                gc.setFill(Color.WHITE);
                gc.fillRect(0, 0, w, h);

                gc.setStroke(Color.LIGHTGRAY);
                gc.strokeRect(Herbivore.OFFSET, Herbivore.OFFSET, Herbivore.SIZE, Herbivore.SIZE);
                gc.strokeRect(Carnivore.OFFSET, Carnivore.OFFSET, Carnivore.SIZE, Carnivore.SIZE);

                for (Animal a : animals) a.kreslit(gc);
            }
        }.start();
    }

    @FXML
    private void onAddHerbivore() {
        animals.add(new Herbivore());
    }

    @FXML
    private void onAddCarnivore() {
        animals.add(new Carnivore());
    }

    @FXML
    private void onChangeDirection() {
        for (Animal a : animals) {
            if (a instanceof Carnivore c) {
                c.changeDirection();
            }
        }
    }

    @FXML
    private void onToggleRun() {
        running = !running;
        btnStop.setText(running ? "Zastaviť" : "Spustiť");
    }
}