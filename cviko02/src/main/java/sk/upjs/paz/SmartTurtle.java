package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.awt.*;

public class SmartTurtle extends Turtle {

//    public void chain(int beadCount, int beatRadius) {
//        this.penUp();
//        this.setFillColor(Color.BLUE);
//        for (int i = 0; i <; i++) {
//
//        }


    public void ngon(int n, double sideLength) {
        double inner_angle = 360.0 / n;
        double external_angle = (180 - inner_angle) / 2;
        double distance = (sideLength / 2) / Math.sin(Math.toRadians(inner_angle / 2));
        for (int i = 0; i < n; i++) {
            this.penUp();
            this.step(distance);
            this.turn(180 - external_angle);
            this.penDown();
            this.step(sideLength);
            this.step(-sideLength);
            this.penUp();
            this.turn(-(180 - external_angle));
            this.step(-distance);
            this.turn(inner_angle);
        }
    }

    public void dashedLine(int n, double segmentLength) {
        for (int i = 0; i < n; i++) {
            this.penDown();
            this.step(segmentLength / 4);
            this.penUp();
            this.step(segmentLength / 2);
            this.penDown();
            this.step(segmentLength / 4);

        }
    }

    public void rgbChain(int beadCount, double beadRadius) {
        this.penUp();
        int color = 0;
        for (int i = 0; i < beadCount; i++) {
            if (i % 3 == 0) {
                this.setFillColor(Color.BLUE);
            }
            if (i % 3 == 1) {
                this.setFillColor(Color.green);

            }
            if (i % 3 == 2) {
                this.setFillColor(Color.red);

            }
            this.dot(beadRadius);
            this.step(beadRadius * 2);

        }
    }


    public void circleWalk(int stepCount, double radius) {
        double startX = this.getX();
        double startY = this.getY();
        double direction = this.getDirection();
        boolean jeMimo = false;

        for (int i = 0; i < stepCount; i++) {
            this.turn(Math.random() * 360);
            this.step(5);

            if (distanceTo(startX, startY) > radius) {
                jeMimo = true;
            }

            if (jeMimo) {
                this.step(-5);
                jeMimo = false;
            }

        }

    }

    public void tripleCircleWalk(int stepCount, double radius) {
        double startX = this.getX();
        double startY = this.getY();
        double direction = this.getDirection();
        boolean jeMimo = false;

        for (int i = 0; i < stepCount; i++) {

            if (distanceTo(startX, startY) > radius) {
                jeMimo = true;

            }
            if (distanceTo(startX, startY) < radius / 3) {
                this.penUp();

            } else if (distanceTo(startX, startY) < radius / 3 * 2) {
                this.penDown();
                this.setPenColor(Color.red);
            } else {
                this.penDown();
                this.setPenColor(Color.blue);
            }

            this.turn(Math.random() * 360);
            this.step(5);

            if (jeMimo) {
                this.step(-5);
                jeMimo = false;
            }
        }


    }

    public void square(int stepCount, double sidelenght) {
        double startX = this.getX();
        double startY = this.getY();
        double direction = this.getDirection();
        boolean jeMimo = false;

        for (int i = 0; i < stepCount; i++) {

            this.turn(Math.random() * 360);
            this.step(5);

            if (this.getX() > startX + sidelenght / 2 || this.getX() < startX - sidelenght / 2) {
                jeMimo = true;
            }
            if (this.getY() > startY + sidelenght / 2 || this.getY() < startX - sidelenght / 2) {
                jeMimo = true;
            }
            if (jeMimo) {
                this.step(-5);
                jeMimo = false;
            }

        }

    }

}


