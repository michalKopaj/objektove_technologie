package com.example.test;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Semafor extends Canvas {
    private int stav = 0;
    private boolean auto = true;
    private boolean vypnuty = false;
    private boolean blikne = false;
    private GraphicsContext gc;
    private Timeline casovac;

    public Semafor() {
        super(20, 80);
        gc = getGraphicsContext2D();
        casovac = new Timeline(new KeyFrame(Duration.millis(1000), e -> tik()));
        casovac.setCycleCount(Timeline.INDEFINITE);
        casovac.play();
        vykresli();
    }

    private void tik() {
        if (vypnuty) {
            blikne = !blikne;
        } else {
            stav = (stav + 1) % 4;
        }
        vykresli();
    }

    public void zmenaStavu() {
        if (auto || vypnuty) return;
        stav = (stav + 1) % 4;
        vykresli();
    }

    public void prepniRezim() {
        if (vypnuty) return;
        auto = !auto;
        if (auto) casovac.play();
        else casovac.stop();
    }

    public void prepniVypnutie() {
        vypnuty = !vypnuty;
        if (vypnuty) {
            blikne = true;
            casovac.play();
        } else {
            if (auto) casovac.play();
            else casovac.stop();
        }
        vykresli();
    }

    public boolean isAuto() { return auto; }
    public boolean isVypnuty() { return vypnuty; }

    public void vykresli() {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 20, 80);
        gc.setStroke(Color.WHITE);
        gc.strokeOval(2, 10, 16, 16);
        gc.strokeOval(2, 30, 16, 16);
        gc.strokeOval(2, 50, 16, 16);

        if (vypnuty) {
            if (blikne) {
                gc.setFill(Color.ORANGE);
                gc.fillOval(2, 30, 16, 16);
            }
            return;
        }

        switch (stav) {
            case 0:
                gc.setFill(Color.RED);
                gc.fillOval(2, 10, 16, 16);
                break;
            case 1:
                gc.setFill(Color.RED);
                gc.fillOval(2, 10, 16, 16);
                gc.setFill(Color.ORANGE);
                gc.fillOval(2, 30, 16, 16);
                break;
            case 2:
                gc.setFill(Color.GREEN);
                gc.fillOval(2, 50, 16, 16);
                break;
            case 3:
                gc.setFill(Color.ORANGE);
                gc.fillOval(2, 30, 16, 16);
                break;
        }
    }
}