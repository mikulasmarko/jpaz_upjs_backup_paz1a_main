package sk.upjs.paz;

import sk.upjs.jpaz2.Pane;
import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class Obdlznik extends Tvar {

    private double a;
    private double b;

    public Obdlznik(double surX, double surY, Color color, double a, double b) {
        super(surX, surY, color);
        this.a = a;
        this.b = b;
    }

    @Override
    public void vykresliSa(Pane plocha) {
        Turtle turtle = new Turtle(getSurX(), getSurY());
        plocha.add(turtle);
        turtle.setFillColor(this.getColor());


        plocha.remove(turtle);
    }
}
