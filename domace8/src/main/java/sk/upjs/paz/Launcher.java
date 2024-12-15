package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

    public static void main(String[] args) {
        ZoznamOdberov zozanm = new ZoznamOdberov();
        zozanm.pridaj(new Odber("Marek", "2102182", 412, true));
        zozanm.pridaj(new Odber("Marek", "210215642", 4112, true));
        zozanm.pridaj(new Odber("Marek", "210432182", 412, true));
        zozanm.pridaj(new Odber("Marek", "2102182", 412, true));
        ;
        System.out.println(zozanm.najvytazenejsiePracovisko());

    }
}