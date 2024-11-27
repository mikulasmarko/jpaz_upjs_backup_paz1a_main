package sk.upjs.paz;

import sk.upjs.jpaz2.Pane;

import java.awt.*;

public class Tvar {

    private double surX;
    private double surY;
    private Color color;


    public Tvar(double surX, double surY, Color color) {
        this.surX = surX;
        this.surY = surY;
        this.color = color;
    }

    public void vykresliSa(Pane plocha){
        System.err.println("asi ne moj zlaty");
    }

    public double getSurX() {
        return surX;
    }

    public void setSurX(double surX) {
        this.surX = surX;
    }

    public double getSurY() {
        return surY;
    }

    public void setSurY(double surY) {
        this.surY = surY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
