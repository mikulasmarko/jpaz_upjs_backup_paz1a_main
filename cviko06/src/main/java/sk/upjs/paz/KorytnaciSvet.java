package sk.upjs.paz;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import sk.upjs.jpaz2.*;

public class KorytnaciSvet extends WinPane {
    /**
     * Referencia na pole korytnaciek
     */
    private Turtle[] korytnacky = null;

    /**
     * Inicializacna metoda (konstruktor)
     */
    public KorytnaciSvet() {
        this.korytnacky = new Turtle[0];
    }

    /**
     * Metoda na pridanie korytnacky na zadanych suradniciach
     */
    public void pridajKorytnacku(int x, int y) {
        Turtle novaKorytnacka = new Turtle();
        this.add(novaKorytnacka);
        novaKorytnacka.setPosition(x, y);

        Turtle[] noveKorytnacky = new Turtle[this.korytnacky.length + 1];
        System.arraycopy(this.korytnacky, 0, noveKorytnacky, 0, this.korytnacky.length);
        noveKorytnacky[noveKorytnacky.length - 1] = novaKorytnacka;

        this.korytnacky = noveKorytnacky;
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        if (!(detail.isAltDown() || detail.isControlDown() || detail.isShiftDown())) {
            this.pridajKorytnacku(x, y);
        }
    }

    public void vystrelNaTazisko() {
        double X = 0;
        double Y = 0;
        for (int i = 0; i < korytnacky.length; i++) {
            double aktualneX = this.korytnacky[i].getX();
            double aktualneY = this.korytnacky[i].getY();
            X = X + aktualneX;
            Y = Y + aktualneY;

        }
        X = X / this.korytnacky.length;
        Y = Y / this.korytnacky.length;
        for (int i = 0; i < korytnacky.length; i++) {
            double povodnaX = this.korytnacky[i].getX();
            double povodnaY = this.korytnacky[i].getY();
            this.korytnacky[i].moveTo(X, Y);
            this.korytnacky[i].setPosition(povodnaX, povodnaY);

        }
    }

    public int[] histogram(double x, double y, double d) {

        double vzdialenostNajdalej = Double.MIN_NORMAL;
        for (int i = 0; i < korytnacky.length; i++) {
            if (this.korytnacky[i].distanceTo(x, y) > vzdialenostNajdalej) {
                vzdialenostNajdalej = this.korytnacky[i].distanceTo(x, y);
            }
        }
        int velkostPola = (int) (vzdialenostNajdalej / d) + 1;
        System.out.println(velkostPola);
        int[] pole = new int[velkostPola];

        for (int i = 0; i < velkostPola; i++) {
            for (int j = 0; j < korytnacky.length; j++) {
                if (korytnacky[j].distanceTo(x, y) >= i * d && korytnacky[j].distanceTo(x, y) < i * d + d) {
                    pole[i]++;
                }
            }
        }
        return pole;
    }

    public void testHistogram(double x, double y, double d) {
        int[] p = this.histogram(x, y, d);
        System.out.print("histogram(" + x + ", " + y + ", " + d + "): ");
        System.out.println(Arrays.toString(p));
    }


    public void doStvorca(double dlzkaStrany) {
        if (korytnacky == null) {
            return;
        }
        Turtle pomocnik = new Turtle();
        pomocnik.penUp();
        this.add(pomocnik);
        int idKorytnacky = 0;
        int pocetKorNaStranu = korytnacky.length / 4;
        double dlzkaMedziKorytnackami = dlzkaStrany / (pocetKorNaStranu + 1);
        for (int j = 0; j < 4; j++) {


            pomocnik.step(dlzkaStrany / 2);
            pomocnik.turn(90);
            pomocnik.step(-dlzkaStrany / 2);
            for (int i = 0; i < pocetKorNaStranu; i++) {
                pomocnik.step(dlzkaMedziKorytnackami);
                korytnacky[idKorytnacky].setPosition(pomocnik.getPosition());
                idKorytnacky++;
            }
            pomocnik.step(-pocetKorNaStranu * dlzkaMedziKorytnackami);
            pomocnik.step(dlzkaStrany / 2);
            pomocnik.turn(-90);
            pomocnik.step(-dlzkaStrany / 2);
            pomocnik.turn(90);
        }
        this.remove(pomocnik);
    }


    public double explozia(double x, double y, double sila) {
        if (korytnacky == null) {
            return 0;
        }
        double maxVzdialenostOdhodu = 0;

        for (int i = 0; i < korytnacky.length; i++) {
            double d = korytnacky[i].distanceTo(x, y);
            double odhodenie = (sila * sila) / (d * d * d * d);
            korytnacky[i].penUp();
            korytnacky[i].setDirectionTowards(x, y);
            ;
            korytnacky[i].turn(180);
            korytnacky[i].step(odhodenie);
            if (odhodenie > maxVzdialenostOdhodu) {
                maxVzdialenostOdhodu = odhodenie;
            }
        }
        return maxVzdialenostOdhodu;
    }

    public double casDoPrichodu(double x, double y) {
        if (korytnacky == null) {
            return 0;
        }
        double vysledok = 0;
        int idKorytnacky = (int) (Math.random() * (korytnacky.length));
        double vzdialost = korytnacky[idKorytnacky].distanceTo(x, y);
        double uhol = korytnacky[idKorytnacky].directionTowards(x, y);
        double opacnyUhol = 360 - uhol;
        System.out.println(uhol + " " + opacnyUhol + " " + vzdialost);

        return vzdialost + Math.min(uhol, opacnyUhol);
    }


    public void prestrelka(int idxPrvehoStrelca, Color farbaStriel) {









    }
}


