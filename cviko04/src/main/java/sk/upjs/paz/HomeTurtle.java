package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class HomeTurtle extends Turtle {


    public void square(double strana) {

    }

    public void squardot(double size) {
        double premenna = size; // vytvorim si premennu aby som nezasahoval do inputu
        double vzdialenost; //toto je en pre zachovanie vzdialenosti aby som vedel dostat kortnacku do rohu stvoruholnika a spat
        this.penUp(); // zdvihnem pero kedze ho nebudem potrebovat, nechcem aby korytnacka zanechavla ciaru
        while (premenna > 1) { // pouzijem while cyklus aby mi bezalo ky nie je utvar 'neviditelny; tj menej jak 1px
            this.setFillColor(Color.lightGray);
            this.dot(premenna);//robim gulicku
            vzdialenost = premenna;
            premenna = Math.sqrt(2) * premenna; // podla pythagorovej vypocitam vzdialenost
            this.setFillColor(Color.darkGray);
            this.turn(-45);
            this.step(vzdialenost);
            this.turn(45);//dostanem sa do rohu kocky
            this.openPolygon();
            for (int i = 0; i < 4; i++) {
                this.turn(90);
                this.step(premenna);//robim stvorec
            }
            this.closePolygon();
            premenna = premenna / 2;
            this.turn(-45);
            this.step(-vzdialenost);//vratim sa z rohu stvorca do pociatocnej pozicii
            this.turn(45);
        }
    }

    public int divergence(double c) {
        double sum = 0.0;
        //vytvorim premennu do ktorej si budem ukladat finalny sucet
        int cislo_n = 1; //cislo n zacina na 1
        int cycleCounter = 0;

        // tu si vytvorim ktory bude
        while (sum < c) {
            if (cislo_n % 2 == 0) { // ak je cislo cislo_n parne
                sum += 1.0 / cislo_n;// pripocitam nove cislo k final suctu
            } else { // ak je cislo_n neprne
                sum += (cislo_n - 1) / (double) cislo_n; // pripocitam nove cislo k final suctu
            }
            cislo_n++;//zvysim n o jeden
            cycleCounter++;
        }
        if (cycleCounter == 0) { //ak sa nepodari vstupit do cyklu, vrati 1
            return cislo_n;
        } else {
            return cislo_n - 1;//vysledok ak sa mu podari vojst do cyklu bude cislon-1
        }
        // vráti posledné cislo_n, pre ktorého suma bola >= c, takze to co bolo predtym jak a vyhodilo z cyklu
    }


    public boolean isUniDigitNumber(int n) {
        int num = Math.abs(n);// iba okopirovanie cisla aby som nezasahoval do inputu + si spravim zcisla absolutnu hodnou aby som sa zbavil minusu
        int firstDigit = num % 10;//zistim aka je je cifra na mieste jednotiek, ak je to cele z rovnakych tak su vsetky rovnake aj s prvou
        while (num != 0) { //vytvorim cyklus kym cislo nebude 0
            int x = num % 10;
            num = num / 10;
            if (x == firstDigit) {//ak sa rovnaju kontrola bude pokracovat na dalsiu cifru
                continue;
            } else {
                return false; // ak sa nerovnaju vyhodi false
            }
            //mohol som to dat aj ze if (x!=firstGigit){return false;}ale takto sa mi to viac pacilo
        }
        return true;//ak prejde celym cyklom tak je zlozene z rovnakych cifier a hodi true
    }

    public int countHammingDistance(int number1, int number2) {
        int num1 = Math.max(number1, number2);
        int num2 = Math.min(number1, number2);//toto je len prepis inputu, plus si urcim ze num1 je vacsie z tych dvoch
        int counter = 0;//vytvorim pocitadlo na pocitanie zhod na mieste
        int counter2 = 0;//spocita kolko cifier malo vacsie cislo
            while (num1 != 0) {
                if (num1 % 10 == num2 % 10) {
                counter++;//pripocitava zhodu
            }
            num1 = num1 / 10;
            num2 = num2 / 10;
            counter2++;//pripocitava celkovy pocet cifier dlhsieho cisla
        }
        return counter2 - counter;//vrati pocet rozdielov
    }


}