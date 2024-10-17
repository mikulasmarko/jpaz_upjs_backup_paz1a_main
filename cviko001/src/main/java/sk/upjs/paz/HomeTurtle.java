package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class HomeTurtle extends Turtle {

    public void flower(double radius) {
        this.penUp();
        this.setFillColor(Color.red);
        for (int i = 0; i < 10; i++) {
            this.step((radius));
            this.dot(radius / 2);
            this.step(-radius);
            this.turn(36);
        }
        this.setFillColor(Color.yellow);
        this.dot(radius);
    }

    public void arrow(double size) {
        this.penUp();
        this.openPolygon();
        this.turn(-90);
        this.step(size / 2);
        this.turn(120);
        this.step(size);
        this.turn(120);
        this.step(size);
        this.turn(120);
        this.step(size / 2);
        this.turn(90);
        this.closePolygon();
    }

    public void navigationArrow(double size) {
        for (int i = 0; i < 5; i++) {
            this.arrow(size);
            this.step(size / 2);
        }
        this.step(-size * 5 / 2);
    }

    public void hexagon(double size) {
        this.penUp();
        this.step(size);
        this.penDown();
        this.turn(120);
        for (int i = 0; i < 6; i++) {
            this.step(size);
            this.turn(360 / 6);
        }
        this.turn(-120);
        this.penUp();
        this.step(-size);
        this.penDown();
    }

    public void beehive(double size) {
        this.setPenColor(Color.green);
        this.turn(0);
        for (int i = 0; i < 6; i++) {
            this.penUp();
            this.step(size);
            this.turn(-120);
            this.step(-size);
            this.hexagon(size);
            this.penUp();
            this.step(size);
            this.turn(120);
            this.step(-size);
            this.turn(60);
        }

    }

    public void smartWatch(double radius, int hh, int mm) {
        this.setFillColor(Color.blue);
        this.dot(radius);
        this.setFillColor(Color.lightGray);
        this.dot(radius - radius / 4);
        for (int i = 0; i < 12; i++) {
            this.penUp();
            this.step(0.5 * radius);
            this.penDown();
            this.step(0.25 * radius);
            this.penUp();
            this.step(-0.75 * radius);
            this.turn(360 / 12);
        }
        this.penDown();
        this.setPenColor(Color.red);
        this.setPenWidth(5);
        this.setDirection(360 / 12 * hh + mm * 0.5);
        this.step(radius / 3);
        this.step(-radius / 3);
        this.setPenWidth(3);
        this.setDirection(360 / 60 * mm);
        this.step(radius / 3 * 2);
        this.step(-radius / 3 * 2);
        this.setFillColor(Color.blue);
        this.dot(radius / 10);
        this.setDirection(0);
        this.setPenColor(Color.black);
        this.setPenWidth(1);

    }

    public void flagOfSouthKorea(int stepCount, double height) {
        // ... inicializacne prikazy
        double startX = this.getX();
        double startY = this.getY();
        double direction = this.getDirection();
        boolean jeMimo = false;
        for (int i = 0; i < stepCount; i++) {
            // ... prikazy na nastavenie farby podla aktualnej pozicie

            if (distanceTo(startX, startY) < height && startY < getY()) {
                this.setPenColor(Color.blue);
            } else if (distanceTo(startX, startY) < height && startY > getY()) {
                this.setPenColor(Color.red);
            }
            if (distanceTo(startX + 0.125 * height, startY) < 0.125 * height) {
                this.setPenColor(Color.blue);

            } else if (distanceTo(startX - 0.125 * height, startY) < 0.125 * height) {
                this.setPenColor(Color.red);
            }

            if (distanceTo(startX, startY) > height / 4) {
                this.setPenColor(Color.white);

            }


            this.turn(Math.random() * 360);
            this.step(5);


            // ... prikazy, resp. podmienka, ktore zabezpecia, ze korytnacka
            if (this.getX() > startX + height*3/4 || this.getX() < startX - height*3/4) {
                jeMimo = true;
            }
            if (this.getY() > startY + height/2 || this.getY() < startX - height/2) {
                jeMimo = true;
            }
            // nevyjde mimo definovanej obdlznikovej oblasti


            if (jeMimo) {
                this.step(-5);
                jeMimo = false;
            }
        }
        this.setPosition(startX,startY);
        this.setDirection(direction);

        // ... prikazy, ktore obnovia vychodiskovy stav
    }

    public void sipka(double sirka, double dlzka) {
        this.penUp();
        this.turn(-90);
        this.step(sirka / 2);
        this.turn(90);
        this.openPolygon();
        this.step(dlzka);
        this.turn(30);
        this.step(sirka);
        this.turn(-60);
        this.step(-sirka);
        this.turn(30);
        this.step(-dlzka);
        this.turn(-30);
        this.step(sirka);
        this.turn(60);
        this.step(-sirka);
        this.turn(-30);
        this.closePolygon();
        this.turn(90);
        this.step(sirka / 2);
        this.turn(-90);

    }

    public void sipkovnica(int pocetSipok, double sirka, double dlzkaPrvej, double medzera) {
        int counter = 0;
        double stepBackCounter=0;
        double dlzkaEdit = dlzkaPrvej;

        for (int i = 0; i < pocetSipok; i++) {

            if (counter % 2 == 0) {
                this.setFillColor(Color.ORANGE);
            } else {
                this.setFillColor(Color.black);
            }
            this.sipka(sirka, dlzkaEdit);
            stepBackCounter+=dlzkaEdit;
            this.step(dlzkaEdit + medzera);
            dlzkaEdit *= 0.7;
            counter += 1;

        }
        stepBackCounter+=pocetSipok*medzera;
        this.step(-stepBackCounter);
    }

}

