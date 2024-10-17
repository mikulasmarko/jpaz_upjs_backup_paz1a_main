package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

    public static void main(String[] args) {
        WinPane wp = new WinPane();
        HomeTurtle pato = new HomeTurtle();
        wp.add(pato);

        double xx = pato.divergence(10);
        System.out.println(xx);

    }
}