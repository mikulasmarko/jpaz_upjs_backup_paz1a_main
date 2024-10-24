package sk.upjs.paz;

import java.awt.*;
import java.awt.event.MouseEvent;

import sk.upjs.jpaz2.*;


public class PrepinaciaHra extends WinPane {
    /**
     * Policka hracej dosky
     */
    private boolean[][] doska = new boolean[6][6];

    /**
     * Indikuje, ci hra bezi (hra konci, ked sa dosiahlo vyherne rozlozenie)
     */
    private boolean hraBezi = true;

    public PrepinaciaHra() {
        this.kresliMriezku();
        this.zamiesaj(30);
//        this.tah(4,1);
        this.kresliDosku();
    }
    /**
     * Nakresli mriezku
     */
    public void kresliMriezku() {
        Turtle k = new Turtle();
        this.add(k);
        for (int i = 1; i < 6; i++) {
            k.setPosition(i * 50, 0);
            k.moveTo(i * 50, this.getHeight());
        }
        for (int i = 1; i < 6; i++) {
            k.setPosition(0, i * 50);
            k.moveTo(this.getWidth(), i * 50);
        }
        this.remove(k);
    }

    /**
     * Nakresli farebne kamene na zaklade obsahu policok
     * v this.doska
     */
    public void kresliDosku() {
        Turtle kreslic = new Turtle();
        this.add(kreslic);
        for (int stlpce = 0; stlpce < 6; stlpce++) {
            for (int riadky = 0; riadky < 6; riadky++) {
                kreslic.setPosition(25 + stlpce * 50, 25 + riadky * 50);
                kreslic.setFillColor(Color.red);
                if (this.doska[stlpce][riadky]) {
                    kreslic.setFillColor(Color.BLUE);
                }
                kreslic.dot(20);
            }
        }
        this.remove(kreslic);
    }

    /**
     * Overi, ci riadok r a stlpec s su platne suradnice
     */
    public boolean dobraSuradnica(int r, int s) {

        return (r >= 0) && (r < 6) && (s >= 0) && (s < 6);
    }

    /**
     * Zrealizuje tah, kedy bolo zatlaceny prepinac na policku
     * v riadku r a stlpci s
     */
    public void tah(int r, int s) {
        int[][] smery = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int aktualnyS = 0;
        int aktualnyR = 0;

        for (int i = 0; i < smery.length; i++) {
            aktualnyS = s + smery[i][0];
            aktualnyR = r + smery[i][1];
            if (dobraSuradnica(aktualnyR, aktualnyS)) {
                this.doska[aktualnyS][aktualnyR] = !this.doska[aktualnyS][aktualnyR];
            }
        }
    }
    /**
     * Vytvori startovacie rozlozenie kamenov tak, ze spravi
     * zadany pocet nahodnych prepnuti (tahov)
     */
    public void zamiesaj(int pocetMiesani) {
        int stlpec = 0;
        int riadok = 0;
        for (int i = 0; i < pocetMiesani; i++) {
            stlpec = (int) (Math.random() * 6);
            riadok = (int) (Math.random() * 6);
            this.tah(riadok, stlpec);
        }
    }

    /**
     * Vrati, ci v aktualnom stave policok je kresliaca plocha
     * jednofarebna
     */
    public boolean jeVyherna() {

        boolean nulta = doska[0][0];
        for (int stlpce = 0; stlpce < 6; stlpce++) {
            for (int riadky = 0; riadky < 6; riadky++) {
                if (nulta != doska[riadky][stlpce]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        if (hraBezi) {
            int kliknutyRiadok = y / 50;
            int kliknutyStlpec = x / 50;
            tah(kliknutyRiadok, kliknutyStlpec);
            this.kresliDosku();
            if (jeVyherna()) {
                hraBezi = false;
                System.out.println("gratulujem");
            }
        }

    }
}