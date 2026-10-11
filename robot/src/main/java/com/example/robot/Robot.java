package com.example.robot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Robot extends Canvas{
    private GraphicsContext gc;
    private int smer=1;
    private int rychlost=5;
    private boolean auto=false;
    private Timeline casovac;

    public Robot(double x,double y){
        super(40,40);
        setLayoutX(x);
        setLayoutY(y);
        gc=getGraphicsContext2D();
        vykresli();


        casovac=new Timeline(new KeyFrame(Duration.millis(50),e -> posun()));
        casovac.setCycleCount(Timeline.INDEFINITE);
        setOnKeyPressed(evt ->spracuj(evt));
        setOnMouseClicked(evt -> klik());
        setFocusTraversable(true);
        requestFocus();
    }
    private void vykresli() {
        gc.clearRect(0, 0, 40, 40);
        gc.setFill(Color.BLUE);
        gc.fillRect(0, 0, 40, 40);
        gc.setFill(Color.YELLOW);
        switch (smer) {
            case 0:
                gc.fillRect(0, 0, 40, 10);
                break;
            case 1:
                gc.fillRect(30, 0, 10, 40);
                break;
            case 2:
                gc.fillRect(0, 30, 40, 10);
                break;
            case 3:
                gc.fillRect(0, 0, 10, 40);
                break;


        }


    }

    private void spracuj(KeyEvent evt){
        if(auto) return;
        KeyCode k = evt.getCode();
        if (k == KeyCode.W) smer=0;
        else if (k == KeyCode.D) smer=1;
        else if (k == KeyCode.S) smer=2;
        else if (k == KeyCode.A) smer=3;
        else return;
        posun();




    }
    private void posun(){
                if(getScene()==null) return;
                double x=getLayoutX();
                double y=getLayoutY();
                switch(smer){
                    case 0: y -=rychlost;break;
                    case 1: x +=rychlost;break;
                    case 2: y +=rychlost;break;
                    case 3: x -=rychlost;break;


                }
                double maxX=getScene().getWidth()-getWidth()   ;
                double maxY=getScene().getHeight()-getHeight();

                boolean narazil =false;
                if(x<0) {x=0;narazil=true;}
                if(x>maxX) {x=maxX;narazil=true;}
                if(y<0){y=0;narazil=true;}
                if(y>maxY) {y=maxY;narazil=true;}

                setLayoutX(x);
                setLayoutY(y);
                if (narazil && auto) smer=(smer + 2) %4;
                vykresli();
        }
    public void zapniAutomat(){
                auto=true;
                casovac.play();

        }
    public void vypniAutomat() {
            auto = false;
            casovac.stop();
        }
    public void klik()            {
               if(auto) vypniAutomat();
               else zapniAutomat();
               requestFocus();

    }

}
