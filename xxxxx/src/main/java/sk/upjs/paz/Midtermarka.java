package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.awt.*;

public class Midtermarka extends Turtle {

    // Task 1 done
    public void christmasTree(int size, double radius) {

        this.penUp();
        double startX = this.getX();
        double startY = this.getY();
        double startDir = this.getDirection();
        System.out.println(startDir);
        int dotcount = 1;
        Color svetla = new Color(118, 205, 38);
        Color tmava = new Color(103, 158, 47);


        for (int j = 0; j < size; j++) {
            this.setPosition(startX, startY);
            this.setDirection(startDir);
            this.turn(210);
            this.step(j * (radius * 2));
            this.turn(-120);
            for (int k = 0; k < dotcount; k++) {
                if (k == 0 || k == dotcount - 1) {
                    setFillColor(svetla);
                } else {
                    setFillColor(tmava);
                }
                this.dot(radius);
                this.step(radius * 2);
            }
            dotcount++;


        }
        this.setPosition(startX, startY);
        this.setDirection(startDir);


    }

    // Task 2 done
    public boolean divisibleDigitsSums(int m, int n) {

        int cislo1 = 0;
        int cislo2 = 0;

        while (m > 0) {
            cislo1 = cislo1 + m % 10;
            m = m / 10;
        }

        while (n > 0) {
            cislo2 = cislo2 + n % 10;
            n = n / 10;
        }
        if (Math.max(cislo1, cislo2) % Math.min(cislo1, cislo2) == 0) {
            return true;
        }
        return false;
    }


    // Task 3 done
    public int containsTwinChar(String s) {

        int couter = 0;
        String[] pole = s.split(" ");

        for (int i = 0; i < pole.length; i++) {
            boolean jeTam = false;
            for (int j = 0; j < pole[i].length() - 1; j++) {

                pole[i] = pole[i].toLowerCase();
                if (pole[i].charAt(j) == pole[i].charAt(j + 1)) {
                    jeTam = true;
                }
            }
            if (jeTam) {
                couter++;
            }

        }
        return couter;
    }

}
