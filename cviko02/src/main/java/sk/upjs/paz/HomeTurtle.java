package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class HomeTurtle extends Turtle {
    public void flagOfSouthKorea(int stepCount, double height) {
        //zistim si kde korytnacka zacinala a jej natocenie
        double startX = this.getX();
        double startY = this.getY();
        double direction = this.getDirection();
        boolean jeMimo = false;

        for (int i = 0; i < stepCount; i++) {
            // ... prikazy na nastavenie farby podla aktualnej pozicie

            if (distanceTo(startX, startY) < height && startY < getY()) {
                this.setPenColor(Color.blue);//dolna polovica kruhu, nastavi sa farba na modru
            } else if (distanceTo(startX, startY) < height && startY > getY()) {
                this.setPenColor(Color.red); //dolna polovica kruhu, nastavi sa farba na cerveu
            }

            if (distanceTo(startX + (0.125 * height), startY) < (0.125 * height)) {
                this.setPenColor(Color.blue);

            } else if (distanceTo(startX - (0.125 * height), startY) < (0.125 * height)) {
                this.setPenColor(Color.red);
            }

            if (distanceTo(startX, startY) > height / 4) {
                this.setPenColor(Color.white);

            }


            this.turn(Math.random() * 360);
            this.step(5);



            if (this.getX() > (startX + height * 0.75) || this.getX() < (startX - height * 0.75)) {
                jeMimo = true;
            }
            if (this.getY() > (startY + height / 2) || this.getY() < (startY - height / 2)) {
                jeMimo = true;
            }

            if (jeMimo) {
                this.step(-5);
                jeMimo = false;
            }
        }
        this.setPosition(startX, startY);
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
        double stepBackCounter = 0;
        double dlzkaEdit = dlzkaPrvej;

        for (int i = 0; i < pocetSipok; i++) {

            if (counter % 2 == 0) {
                this.setFillColor(Color.ORANGE);
            } else {
                this.setFillColor(Color.black);
            }
            this.sipka(sirka, dlzkaEdit);
            stepBackCounter += dlzkaEdit;
            this.step(dlzkaEdit + medzera);
            dlzkaEdit *= 0.7;
            counter += 1;

        }
        stepBackCounter += pocetSipok * medzera;
        this.step(-stepBackCounter);
    }
}
