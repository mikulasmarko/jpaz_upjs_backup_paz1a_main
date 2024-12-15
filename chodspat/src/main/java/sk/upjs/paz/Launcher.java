package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.awt.*;

public class Launcher {

    public static void main(String[] args) {

        Tvar neviem = new Obdlznik(30, 100, Color.BLUE, 50,30);
        WinPane wp = new WinPane();
        neviem.vykresliSa(wp);
    }
}