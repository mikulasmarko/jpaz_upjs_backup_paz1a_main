package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.awt.*;

public class SmartTurtle extends Turtle {

    // put new methods here
//    public void colorChange(){
//        float r = new Math.random();
//        float g = new Math.random();
//        float b = new Math.random();
//
//        this.setPenColor(Color.getColor(r,g,b));
//    }

    public void concrenticCircle(double radius) {
        int count = 0;
        double x = radius;
        while (x >= 1) {
            if (count % 3 == 1) {
                this.setFillColor(Color.red);
            }
            if (count % 3 == 2) {
                this.setFillColor(Color.blue);
            }
            if (count % 3 == 0) {
                this.setFillColor(Color.gray);
            }


            this.dot(radius);
            x *= 0.8;
            count++;
        }


    }
}
