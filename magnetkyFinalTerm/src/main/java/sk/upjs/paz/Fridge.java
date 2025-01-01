package sk.upjs.paz;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Fridge {

    private ArrayList<Magnet> magnetky;

    public Fridge() {
        magnetky = new ArrayList<>();

    }

    public Fridge(String filename) throws FileNotFoundException {
        magnetky = new ArrayList<>();
        loadMagnets(filename);
    }


    public void addMagnet(Magnet magnet) {
        this.magnetky.add(magnet);
    }


    public static Fridge loadMagnets(String filename) throws FileNotFoundException {
        File subor = new File(filename);
        Scanner scanner = new Scanner(subor);
        Fridge vratim = new Fridge();

        while (scanner.hasNextLine()) {
            vratim.addMagnet(Magnet.fromString(scanner.nextLine()));
        }

        scanner.close();
        return vratim;
    }

    public void saveMagnets(String filename) throws FileNotFoundException {

        File subor = new File(filename);
        PrintWriter printWriter = new PrintWriter(subor);
        for (Magnet magnet : magnetky) {
            printWriter.println(magnet.toString());
        }
        printWriter.close();

    }

    @Override
    public String toString() {
        return magnetky.toString();
    }
}