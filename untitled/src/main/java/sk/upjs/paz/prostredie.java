package sk.upjs.paz;

import sk.upjs.jpaz2.ImageTurtleShape;
import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.TurtleShape;
import sk.upjs.jpaz2.WinPane;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class prostredie extends WinPane {

    private String coPojdeNaListok = "";
    private Map<String, Integer> mapaNaBlocek = new HashMap<>();

    public prostredie() {
        this.setHeight(800);
        this.setWidth(800);
        Turtle pomocko = new Turtle();
        TurtleShape shape = new ImageTurtleShape("C://Users//Mikuláš//Downloads//bonko.png");
        pomocko.setShape(shape);
        this.add(pomocko);
        pomocko.setPosition(400, 400);
        pomocko.stamp();
        this.remove(pomocko);
        this.drawGrid();
    }

    public void drawGrid() {
        double a = 200;
        double numy = (int) (this.getHeight() / a);
        double numx = (int) (this.getWidth() / a);
        double height = this.getHeight();
        double widht = this.getWidth();

        Turtle risiak = new Turtle();
        this.add(risiak);
        for (int i = 0; i <= numx; i++) {
            risiak.setPosition(0, i * a);
            risiak.moveTo(widht, a * i);

        }
        for (int i = 0; i <= numy; i++) {
            risiak.setPosition(a * i, 0);
            risiak.moveTo(a * i, height);
        }
        this.remove(risiak);
    }

    public void print() throws IOException {
        String s = "C:\\Users\\Mikuláš\\Desktop\\monitoring\\";
        s = s + Math.random() + ".txt";

        File file = new File(s);
        file.createNewFile();
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(coPojdeNaListok + "\n" + LocalTime.now());
        printWriter.close();
        coPojdeNaListok = "";
    }

    public void addText(String s) {
        coPojdeNaListok = coPojdeNaListok + s + "\n";
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        //espreso
        if (x < 200 && x > 0 && y > 0 && y < 200) {
            System.out.println("espresso added");
            addText("ESPRESSO");
            //printout
        }
        if (x < 400 && x > 200 && y > 0 && y < 200) {
            System.out.println("lungo added");
            addText("LUNGO");
            //printout
        }
        if (x < 600 && x > 400 && y > 0 && y < 200) {
            System.out.println("CAPP added");
            addText("CAPPUCINO");
            //printout
        }


        if (x < 800 && x > 600 && y < 800 && y > 600) {
            try {
                System.out.println("idem tlacit");
                this.print();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}