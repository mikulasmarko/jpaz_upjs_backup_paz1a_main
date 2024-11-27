package sk.upjs.paz;

import sk.upjs.jpaz2.Pane;

import java.awt.*;

public class Obdlznik extends Tvar {

    private double a;
    private double b;

    public Obdlznik(double surX, double surY, Color color, double a, double b) {
        super(surX, surY, color);
        this.a = a;
        this.b = b;
    }

    public void vykresliSa(Pane plocha) {
        System.err.println("ej");
    }


}
