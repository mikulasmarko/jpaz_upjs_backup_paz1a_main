package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTurtle extends Turtle {

    public boolean isWinner(String name, String resultsFilename) {
        name = name.toLowerCase();
        int pocetHlasovPreKandidata = 0;
        int celkovyPocet = 0;


        File f = new File(resultsFilename);
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {               
                String[] riadok = sc.nextLine().split(" ");
                for (int i = 0; i < riadok.length; i++) {
                    if (riadok[i] == name)//chuju použiť equals
 {
                        for (int j = 0; j < riadok.length; j++) {
                            String toNum = riadok[j];
                            try {
                                int num = Integer.parseInt(toNum);
                                celkovyPocet += num;
                                pocetHlasovPreKandidata += num;

                            } catch (NumberFormatException e) {
                                e.printStackTrace();

                            }

                        }

                    } else {
                        for (int j = 0; j < riadok.length; j++) {
                            String toNum = riadok[j];
                            try {
                                int num = Integer.parseInt(toNum);
                                celkovyPocet += num;
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }


        if (pocetHlasovPreKandidata > celkovyPocet / 2) {
            return true;
        }
        return false;
    }

}


