package sk.upjs.paz;

import com.sun.tools.jdeprscan.scan.Scan;
import sk.upjs.jpaz2.Turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextTurtle extends Turtle {

    public double average(String filename) {
        File nf = new File(filename);
        double ciselko = 0;
        int counter = 0;


        try (Scanner scanner = new Scanner(nf)) {


        } catch (FileNotFoundException e) {

        }

        return 0;

    }

    public int countLines(String filename) {
        File nf = new File(filename);

        int counter = 0;

        try (Scanner sc = new Scanner(nf)) {
            while (sc.hasNextLine()) {
                sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("si skoncil");;
        }

        return counter;
    }


}
