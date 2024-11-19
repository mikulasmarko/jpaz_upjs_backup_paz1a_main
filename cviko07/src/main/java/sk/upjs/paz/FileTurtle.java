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
                boolean kandidátNájdený = false;
                for (String slovo : riadok) {
                    if (slovo.equals(name)) {
                        kandidátNájdený = true;
                        break;
                    }
                }
                for (String toNum : riadok) {
                    try {
                        int num = Integer.parseInt(toNum);
                        celkovyPocet += num;
                        if (kandidátNájdený) {
                            pocetHlasovPreKandidata += num;
                        }
                    } catch (NumberFormatException e) {
                        // Informácie o výnimke nie sú potrebné v produkčnom kóde
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Môžeš zvážiť vhodnejšie riešenie pre produkčný kód
        }

        return pocetHlasovPreKandidata > (celkovyPocet / 2);
    }
}