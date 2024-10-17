package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

public class HomeTurtle extends Turtle {


    public int divergence(double c) {
        double sum = 0.0;
        int cislo_n = 1;
        // tu si vytvorim cyklus kery bude bezat furt kym neprestane
        while (sum < c) {
            if (cislo_n % 2 == 0) { // ak je cislo cislo_n parneho typu
                sum += 1.0 / cislo_n;
            } else { // ak je cislo_n cislo typu neparneho
                sum += (cislo_n - 1) / (double) cislo_n;
            }
            cislo_n++;
        }

        return cislo_n - 1;
        // vráti posledné cislo_n, pre ktorého suma bola >= c
    }


}
