package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.io.FileNotFoundException;

public class Launcher {

    public static void main(String[] args) throws FileNotFoundException {


//        Magnet mag1=new Magnet(1,"meno","SK",true,158,"kokotko");
//        Magnet mag2=Magnet.fromString("2\tpriezvisko\tPL\tfalse\t258\tchujko\ttoto mi bolo treba");
//        System.out.println(mag1);
//        System.out.println(mag2);
//        Fridge chlad=new Fridge();
//        chlad.addMagnet(mag1);
//        chlad.addMagnet(mag2);
//        chlad.saveMagnets("mojaChladnicka");

        Fridge moja = new Fridge("mojaChladnicka");
        System.out.println(moja);
    }
}