package sk.upjs.paz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Elife {


    List<Aktivita> mojaAktivita;

    public Elife() {
        mojaAktivita = new ArrayList<>();

    }

    public void pridaj(Aktivita aktivita) {
        mojaAktivita.add(aktivita);
    }

    public static Elife zoSuboru(String nazovSuboru) throws FileNotFoundException {
        File file = new File(nazovSuboru);
        Scanner scanner = new Scanner(file);
        Elife vratim = new Elife();
        while (scanner.hasNextLine() && scanner.hasNext()) {
            vratim.pridaj(Aktivita.zoStringu(scanner.nextLine()));
        }
        scanner.close();

        return vratim;
    }

    public void uloz(String nazovSuboru) throws FileNotFoundException {
        File file = new File(nazovSuboru);
        PrintWriter printWriter = new PrintWriter(file);
        for (Aktivita aktivita : mojaAktivita) {
            printWriter.println(aktivita.toString());

        }
        printWriter.close();

    }

    public String toString() {
        StringBuilder vratim = new StringBuilder();
        for (Aktivita aktivita : mojaAktivita) {
            vratim.append(aktivita).append("\n");
        }
        return vratim.toString();
    }



}