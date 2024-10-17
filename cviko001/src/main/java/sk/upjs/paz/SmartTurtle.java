package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.awt.*;

public class SmartTurtle extends Turtle {

    public void stvorec(double size) {
        for (int i = 0; i < 4; i++) {
            this.step(size);
            this.turn(90);
        }
    }

    public void triangle(double size) {
        this.turn(30);
        for (int i = 0; i < 3; i++) {
            this.step(size);
            this.turn(120);
        }
        this.turn(-30);
    }


    public void house(double size) {
        this.triangle(size);
        this.stvorec(size);

    }

    public void dotDashDot(double lenght) {
        this.step(lenght);
        this.penUp();
        this.step(lenght);
        this.setFillColor(Color.YELLOW);
        this.dot(lenght / 2);
        this.step(lenght);
        this.penDown();
        this.step(lenght);
    }

    public void lupen(double uhol, double velkost) {
        this.turn(-uhol);
        for (int i = 0; i < velkost; i++) {
            this.step(1);
            this.turn(uhol / (velkost / 2));
        }
        this.turn(-uhol * 2);
        for (int i = 0; i < velkost; i++) {
            this.step(-1);
            this.turn(uhol / (velkost / 2));
        }
        this.turn(-uhol);

    }

    public void sun(double radius, int pocet) {
        this.setPenColor(Color.yellow);
        this.setFillColor(Color.yellow);
        for (int i = 0; i < pocet; i++) {
            this.step(radius);
            this.step(-radius);
            this.turn(360 / pocet);
        }
        this.dot(radius / 2);

    }

    public void lopatky(double size) {
        for (int i = 0; i < 8; i++) {
            this.step(size - 10);
            this.turn(45);
            this.step(10);
            this.step(-10);
            this.turn(-45);
            this.step(-(size - 10));
            this.turn(360 / 8);
        }
    }

    public void cross(double size) {
        this.setPenColor(Color.red);
        this.setPenWidth(2);
        for (int i = 0; i < 4; i++) {
            this.step(size);
            this.turn(90);
            this.step(size);
            this.turn(90);
            this.step(size);
            this.turn(-90);
        }
    }

    public void cool(double size) {
        this.setPenWidth(2);
        this.setPenColor(Color.BLUE);
        for (int i = 0; i < 10; i++) {
            this.stvorec(size);
            this.turn(360 / 10);
            this.turn(90);
            this.step(-size);

        }
    }

    public void vyplnenySestuholnik(double size) {
        this.openPolygon();
        for (int i = 0; i < 6; i++) {
            this.step(size);
            this.turn(60);
        }
        this.closePolygon();

    }

    public void kvietok(double size, double uhol, double pocet) {
        for (int i = 0; i < pocet; i++) {
            this.lupen(uhol, size);
            this.turn(360 / pocet);
        }
    }

    public void centeredSquare(double sideLenght) {
        this.penUp();
        this.step(sideLenght / 2);
        this.turn(90);
        this.step(-sideLenght / 2);
        this.penDown();
        this.stvorec(sideLenght);
        this.penUp();
        this.step(sideLenght / 2);
        this.turn(-90);
        this.step(-sideLenght / 2);
    }

}
