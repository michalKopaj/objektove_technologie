package com.example.animal;
import javafx.scene.canvas.GraphicsContext;

public abstract class Animal {

    protected double x,y;
    protected double s;
    protected double rychlost;
    protected  int dir=1;
    protected  final double offset;
    protected  final double size;
    public Animal(double offset, double size, double rychlost) {
        this.offset = offset;
        this.size = size;
        this.rychlost = rychlost;
        this.s=Math.random()*4*size;
        updateXY();
    }
    protected void updateXY() {
        double p = 4 * size;
        s = ((s % p) + p) % p;
        if (s < size) {
            x = offset + s;            y = offset;
        } else if (s < 2 * size) {
            x = offset + size;         y = offset + (s - size);
        } else if (s < 3 * size) {
            x = offset + size - (s - 2 * size); y = offset + size;
        } else {
            x = offset;                y = offset + size - (s - 3 * size);
        }
    }


    public abstract void move();
    public abstract void kreslit(GraphicsContext gc);
}
