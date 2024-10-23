package sk.upjs.paz;

import sk.upjs.jpaz2.WinPane;

public class Poliarka extends WinPane {


    public double priemer(int[] pole) {
        double count = 0;
        for (int i = 0; i < pole.length; i++) {
            count += pole[i];

        }
        return count / pole.length;
    }

    public int pocetOpakovani(int[] pole, int cislo) {
        if (pole == null)
            return 0;
        int sum = 0;
        for (int i = 0; i < pole.length; i++) {
            if (i != cislo) {
                if (pole[i] == pole[cislo]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public int[] zdvojPole(int[] pole) {

        int[] novepole = new int[pole.length * 2];
        int counter = 0;
        for (int i = 0; i < pole.length * 2; i = i + 2) {
            novepole[i] = pole[counter];
            novepole[i + 1] = pole[counter];
            counter++;
        }
        return novepole;

    }

    public boolean jeNeklesajuce(int[] pole) {
        if (pole == null)
            return true;
        for (int i = 0; i < pole.length - 1; i++) {
            if (pole[i] > pole[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int indexNajmensieho(int[] pole, int start, int koniec) {
        int index = 0;
        int minimum= Integer.MAX_VALUE;
        for (int i = start; i < koniec+1; i++) {
            if (pole[i]<minimum) {
                index=1;
                minimum=pole[i];
            }

        }
        return index;
    }


}


