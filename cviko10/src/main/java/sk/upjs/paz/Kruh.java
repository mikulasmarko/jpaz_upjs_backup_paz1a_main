package sk.upjs.paz;

import sk.upjs.jpaz2.Pane;
import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class Kruh extends Tvar {

    private double radius;


    public Kruh(double radius, double X, double Y, Color c) {
        super(X, Y, c);
        this.radius = radius;
    }

    public void vykresliSa(Pane plocha) {

        Turtle turtle = new Turtle(getSurX(), getSurY());
        plocha.add(turtle);
        turtle.setFillColor(this.getColor());
        turtle.dot(radius);

//        System.err.println("ej");
        plocha.remove(turtle);
    }

    public boolean jeVnutornyBod(double x, double y) {
        Turtle nt = new Turtle(getSurX(),getSurY());
        return nt.distanceTo(x, y) < radius;
    }


}
