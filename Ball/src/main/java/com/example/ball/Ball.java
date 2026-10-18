package com.example.ball;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {

    private static final double SPEED_STEP = 0.5;
    private static final double MIN_SPEED = 0.5;
    private static final double MAX_SPEED = 30;

    private final Pane area;
    private double speed = 3;
    private int dirX = 1;
    private int dirY = 1;
    private boolean moving = true;

    private final AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            move();
        }
    };

    public Ball(Pane area, double radius, Color color) {
        super(radius, color);
        this.area = area;
        setCenterX(radius + 20);
        setCenterY(radius + 20);


        setOnMouseClicked(e -> toggleMoving());
    }

    public void start() {
        timer.start();
        moving = true;
    }

    private void move() {
        double w = area.getWidth();
        double h = area.getHeight();
        if (w <= 0 || h <= 0) return;

        double r = getRadius();
        double x = getCenterX() + dirX * speed;
        double y = getCenterY() + dirY * speed;

        if (x - r <= 0) {
            x = r;
            dirX = 1;
        } else if (x + r >= w) {
            x = w - r;
            dirX = -1;
        }


        if (y - r <= 0) {
            y = r;
            dirY = 1;
        } else if (y + r >= h) {
            y = h - r;
            dirY = -1;
        }

        setCenterX(x);
        setCenterY(y);
    }

    public void toggleMoving() {
        if (moving) {
            timer.stop();
        } else {
            timer.start();
        }
        moving = !moving;
    }

    public void faster() {
        speed = Math.min(MAX_SPEED, speed + SPEED_STEP);
    }

    public void slower() {
        speed = Math.max(MIN_SPEED, speed - SPEED_STEP);
    }
}