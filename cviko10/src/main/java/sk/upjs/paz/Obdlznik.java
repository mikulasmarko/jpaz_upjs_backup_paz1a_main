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
        turtle.setFillColor(getColor());
        turtle.penUp();
        turtle.step(a / 2);
        turtle.turn(-90);
        turtle.step(b / 2);
        turtle.turn(90);
        turtle.openPolygon();
        for (int i = 0; i < 2; i++) {
            turtle.turn(90);
            turtle.step(a);
            turtle.turn(90);
            turtle.step(b);
        }
        turtle.closePolygon();

        plocha.remove(turtle);
    }

    public boolean jeVnutornyBod(double x, double y) {


        return true;
    }
}
