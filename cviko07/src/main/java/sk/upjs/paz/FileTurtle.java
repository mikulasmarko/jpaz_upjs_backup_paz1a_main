package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FileTurtle extends Turtle {

    public boolean isWinner(String name, String resultsFilename) {
        name = name.toLowerCase();//zmenim si riadok na male, nech to viem porovnavat
        int pocetHlasovPreKandidata = 0;
        int celkovyPocet = 0;

        File f = new File(resultsFilename);// vytvorim si cestu k suboru

        try (Scanner sc = new Scanner(f)) {//potrebujem scaner aby som mohol pozerat na subor
            // dal som ho do try nech sa potom zavre
            while (sc.hasNextLine()) {
                String[] riadok = sc.nextLine().split(" "); //splitnem si kazdy riadok podla medzery
                boolean nasielSomHo = false;
                int pocetHlasovVRiadku = 0;
                for (int i = 0; i < riadok.length; i++) {//prechadzam kazdym slovom v riadku, skusam ci sa da parsenut
                    String toNumber = riadok[i];
                    try {
                        pocetHlasovVRiadku = parseInt(toNumber);
                        celkovyPocet += pocetHlasovVRiadku;//pripocitam ho celkovemu poctu

                    } catch (Exception e) {//ak mi hodi chybu, neni to cislo=mozem riesit ci to neni kandidat
                        e.printStackTrace();
                        if (name.equals(toNumber.toLowerCase())) {//TODO zmen nazov premennej bo to neni dobre
                            nasielSomHo = true;
                        }
                    }
                }
                if (nasielSomHo) {//ak som ho nasiel pripocitam to aj k nemu
                    pocetHlasovPreKandidata += pocetHlasovVRiadku;
                }
            }
        } catch (FileNotFoundException e) {//odchytavam ze sa nenajde subor
            e.printStackTrace();
        }

        return pocetHlasovPreKandidata > (celkovyPocet / 2);//vrati true/false na zaklade vypoctu
    }






}