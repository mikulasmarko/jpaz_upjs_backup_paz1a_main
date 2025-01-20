package sk.upjs.paz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class listok {

    private String coPojdeNaListok="";

    public listok() {

    }

    public void addText(String s) {
        coPojdeNaListok = coPojdeNaListok + s + "\n";
    }


    public void print() throws IOException {
        String s = "C:\\Users\\Mikuláš\\Desktop\\monitoring\\";
        s = s + Math.random() + ".txt";

        File file = new File(s);
        file.createNewFile();
        PrintWriter printWriter = new PrintWriter(file);
        coPojdeNaListok = coPojdeNaListok + "\n\n.";
        printWriter.println(coPojdeNaListok);
        printWriter.close();
        coPojdeNaListok = "";
    }

}
