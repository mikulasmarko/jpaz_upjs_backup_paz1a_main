package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

    public static void main(String[] args) {
        Aktivita cislo1 = new Aktivita("4815", "9:50:00", "10:10:00", "kokof", 845, "picus", "vwjnc, bowvc, vownsd");
        Aktivita cislo2 = new Aktivita("815", "9:50:00", "10:10:00", "kokof", 845, "picus");
        System.out.println(cislo1.dlzka());
        System.out.println(cislo1.partneri());
        System.out.println(cislo2.partneri());

    }
}