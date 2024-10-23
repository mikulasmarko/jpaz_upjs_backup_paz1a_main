package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.util.Arrays;

public class Launcher {

    public static void main(String[] args) {

//		KorytnaciSvet ks=new KorytnaciSvet();
//		ObjectInspector oi=new ObjectInspector();
//		oi.inspect(ks);
        int[] pole = {1,1,1,2,5,6,8,9};
        Poliarka pl = new Poliarka();
        System.out.println(pl.pocetOpakovani(pole, 5));
        System.out.println(Arrays.toString(pl.zdvojPole(pole)));
        System.out.println(pl.jeNeklesajuce(pole));
        System.out.println(pl.indexNajmensieho(pole,2,6));


    }
}