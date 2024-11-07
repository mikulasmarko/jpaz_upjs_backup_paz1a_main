package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class Midtermpane extends WinPane {

    private Turtle[] korytnacky = new Turtle[12];

    public Midtermpane() {
        for (int i = 0; i < 12; i++) {
            korytnacky[i] = new Turtle();
            this.add(korytnacky[i]);
            korytnacky[i].setPosition(this.getWidth() * Math.random(), this.getHeight() * Math.random() / 2);
            korytnacky[i].setDirection((int) (Math.random() * 4) * 90);
        }
    }

    public int runDown() {

        double najnizsie = Double.MIN_VALUE;
        int counter = 0;
        for (int i = 0; i < korytnacky.length; i++) {

            if (korytnacky[i].getDirection() == 180) {

                if (korytnacky[i].getY() > najnizsie) {
                    najnizsie = korytnacky[i].getY();
                }
            }
        }
        System.out.println(this.getHeight());
        System.out.println(najnizsie);
        double vzdialenost = this.getHeight() - najnizsie;
        System.out.println(vzdialenost);

        for (int i = 0; i < korytnacky.length; i++) {
            if (korytnacky[i].getDirection() == 180) {
                korytnacky[i].step(vzdialenost);
                counter++;

            }

        }


        return counter;
    }


}
