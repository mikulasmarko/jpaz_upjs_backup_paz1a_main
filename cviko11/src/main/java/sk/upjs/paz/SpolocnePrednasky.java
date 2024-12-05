package sk.upjs.paz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class SpolocnePrednasky {

    public static void main(String[] args) {


        // ... ?
        // vyrobit novu mapu, kluc je String, hodnota Integer
        // premenna na pocetRiadkov
        HashMap<String, Integer> mapa = new HashMap<>();
        int counter = 0;

        File subor = new File("prednasky.txt");
        try (Scanner sc = new Scanner(subor)) {
            while (sc.hasNextLine()) {
                counter++;
                String line = sc.nextLine();
                String[] slova = line.split(" ");
                for (int i = 0; i < slova.length; i++) {
                    slova[i].toLowerCase();
                    if (mapa.containsKey(slova[i])) {
                        mapa.put(slova[i], mapa.get(slova[i]) + 1);
                    } else {
                        mapa.put(slova[i], 1);
                    }
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
















        // ...?
        // metoda keySet vrati mnozinu
        // iterujeme mnozinu cez for each
        // metoda get ... int value = mapa.get(kluc)
    }

}

// kto chce, moze skusit predpokladat nekorektny vstup