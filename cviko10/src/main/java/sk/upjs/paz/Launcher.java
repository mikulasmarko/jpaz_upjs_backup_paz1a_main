package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.awt.*;

public class Launcher {

    public static void main(String[] args) {

        Kruh kruh = new Kruh(30, 100, 50, Color.RED);
        WinPane wp = new WinPane();
        kruh.vykresliSa(wp);
    }
}