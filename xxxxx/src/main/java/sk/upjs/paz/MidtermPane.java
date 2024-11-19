package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.awt.*;

public class MidtermPane extends WinPane {

    Turtle[] korytnacky = new Turtle[12];

    public MidtermPane() {
        for (int i = 0; i < 12; i++) {
            korytnacky[i] = new Turtle();
            this.add(korytnacky[i]);
            korytnacky[i].setPosition(Math.random() * this.getWidth(), Math.random() * getHeight());
            korytnacky[i].setDirection((int) (Math.random() * 2) * 180 + 90);
        }


    }


    public int bestSeeker() {

        double maximalNaLavo = getWidth();
        int counter = 0;

        for (int i = 0; i < korytnacky.length; i++) {
            if (korytnacky[i].getDirection() == 90) {
                if (korytnacky[i].getX() < maximalNaLavo) {
                    maximalNaLavo = korytnacky[i].getX();
                }
            }
        }
        System.out.println(maximalNaLavo);

        for (int i = 0; i < korytnacky.length; i++) {
            if (korytnacky[i].getDirection() == 270 && korytnacky[i].getX() > maximalNaLavo) {
                korytnacky[i].setPenColor(Color.RED);
                counter++;

            }
        }

        return counter;
    }

}
