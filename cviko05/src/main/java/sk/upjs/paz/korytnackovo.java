package sk.upjs.paz;

import sk.upjs.jpaz2.JPAZUtilities;
import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;
import java.awt.event.MouseEvent;


public class korytnackovo extends WinPane {

    Turtle[] poleKorytnaciek;

    public korytnackovo() {
        this.poleKorytnaciek = new Turtle[10];


        for (int i = 0; i < poleKorytnaciek.length; i++) {
            double x = Math.random() * this.getWidth();
            double y = Math.random() * this.getHeight();
            poleKorytnaciek[i] = new Turtle();
            this.add(this.poleKorytnaciek[i]);
            this.poleKorytnaciek[i].setPosition(x, y);
        }

    }

    public void posunITU(int idx, double dlzka) {
        this.poleKorytnaciek[idx].step(dlzka);

    }

    public void nahodneFarby() {
        for (int i = 0; i < this.poleKorytnaciek.length; i++) {
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            this.poleKorytnaciek[i].setPenColor(new Color(r, g, b));

        }

    }

    public Color sFarbouVon(int id) {
        return this.poleKorytnaciek[id].getPenColor();
    }


    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        super.onMouseClicked(x, y, detail);
        int idZvolenej = (int) (Math.random() * (poleKorytnaciek.length));
        //this.poleKorytnaciek[idZvolenej].moveTo(x, y);
        this.krok(idZvolenej);

    }

    public void krok(int id) {

        int idPrvej = id;
        int idDruhej = idPrvej + 1;
        if (idDruhej > poleKorytnaciek.length - 1) {
            idDruhej = 0;
        }
//            double prvaX=poleKorytnaciek[idPrvej].getX();
//            double prvaY=poleKorytnaciek[idPrvej].getY();
//            double druhaX=poleKorytnaciek[idDruhej].getX();
//            double druhaY=poleKorytnaciek[idDruhej].getY();

        double vzdialenost = this.poleKorytnaciek[idPrvej].distanceTo(this.poleKorytnaciek[idDruhej].getPosition());
        double uhol = this.poleKorytnaciek[idPrvej].directionTowards(this.poleKorytnaciek[idDruhej].getPosition());
        this.poleKorytnaciek[idPrvej].setDirection(uhol);
        this.poleKorytnaciek[idPrvej].step(vzdialenost / 10);
    }

    public void kroky(int pocet) {
        for (int i = 0; i < pocet; i++) {
            int idZvolenej = (int) (Math.random() * (poleKorytnaciek.length));
            this.krok(idZvolenej);
            JPAZUtilities.delay(100);

        }
    }

    public int pocetTopKorytnaciek(double zhora) {
        int pocet = 0;
        for (int i = 0; i < this.poleKorytnaciek.length; i++) {
            double y = this.poleKorytnaciek[i].getY();
            if (y < zhora) {
                pocet++;
            }

        }
        return pocet;
    }

    public void bezpecnyKruh(int indexKorytnacky) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < this.poleKorytnaciek.length; i++) {
            if (i != indexKorytnacky) {
                if (this.poleKorytnaciek[indexKorytnacky].distanceTo(this.poleKorytnaciek[i].getPosition()) < min) {
                    min = this.poleKorytnaciek[indexKorytnacky].distanceTo(this.poleKorytnaciek[i].getPosition());
                }
            }
        }
        this.poleKorytnaciek[indexKorytnacky].dot(min);
    }

    public int laviciarka() {
        int jejIndex = 0;
        double maxY = 0;
        for (int i = 0; i < this.poleKorytnaciek.length; i++) {
            if (this.poleKorytnaciek[i].getY() > maxY) {
                maxY = this.poleKorytnaciek[i].getY();
                jejIndex = i;
            }
        }
        return jejIndex;
    }

    public double najblizsie() {
        double najmensia = Double.MAX_VALUE;
        for (int i = 0; i < this.poleKorytnaciek.length; i++) {
            for (int j = 0; j < this.poleKorytnaciek.length; j++) {
                if (i != j) {
                    if (this.poleKorytnaciek[i].distanceTo(this.poleKorytnaciek[j].getPosition()) < najmensia) {
                        najmensia = this.poleKorytnaciek[i].distanceTo(this.poleKorytnaciek[j].getPosition());

                    }
                }

            }
        }

        return najmensia;
    }
}
