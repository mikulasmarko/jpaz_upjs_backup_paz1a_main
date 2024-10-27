package sk.upjs.paz;

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
        int velkostPola = (int) (vzdialenostNajdalej / d)+1;
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

}
