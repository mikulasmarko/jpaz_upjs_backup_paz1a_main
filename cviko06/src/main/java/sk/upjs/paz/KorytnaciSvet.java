package sk.upjs.paz;

import java.awt.event.MouseEvent;

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
        X=X/this.korytnacky.length;
        Y=Y/this.korytnacky.length;
        for (int i = 0; i < korytnacky.length; i++) {
            double povodnaX= this.korytnacky[i].getX();
            double povodnaY= this.korytnacky[i].getY();
            this.korytnacky[i].moveTo(X,Y);
            this.korytnacky[i].setPosition(povodnaX,povodnaY);

        }
    }

}
