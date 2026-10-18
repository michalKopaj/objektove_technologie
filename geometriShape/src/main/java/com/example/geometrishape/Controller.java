package com.example.geometrishape;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {
    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private final List<GeometricShape> shapes = new ArrayList<>();
    private final Random random = new Random();

    @FXML
    private void initialize() {
        gc = canvas.getGraphicsContext2D();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                for (GeometricShape s : shapes) {
                    s.move(canvas.getWidth(), canvas.getHeight());
                    s.draw(gc);
                }
            }
        }.start();
    }

    @FXML
    private void addRectangle() {
        shapes.add(new MyRectangle(randomX(), randomY()));
    }

    @FXML
    private void addCircle() {
        shapes.add(new MyCircle(randomX(), randomY()));
    }

    @FXML
    private void addSquare() {
        shapes.add(new MySquare(randomX(), randomY()));
    }

    @FXML
    private void makeCirclesBlue() {
        for (GeometricShape s : shapes) {
            if (s instanceof MyCircle) {
                s.setColor(Color.BLUE);
            }
        }
    }

    @FXML
    private void moveAllDown() {
        for (GeometricShape s : shapes) {
            s.moveDown(30);
        }
    }

    private double randomX() {
        return random.nextDouble() * (canvas.getWidth() - 60);
    }

    private double randomY() {
        return random.nextDouble() * (canvas.getHeight() - 60);
    }
}