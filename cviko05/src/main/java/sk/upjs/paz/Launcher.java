package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

    public static void main(String[] args) {
//        korytnackovo k = new korytnackovo();
//        k.nahodneFarby();
//        System.out.println(k.pocetTopKorytnaciek(300));
//        k.bezpecnyKruh(4);
//        System.out.println(k.najblizsie());
//        k.kroky(1000);
//        String s1 = new String("ahoj");
//        String s2 = new String("ahoj");
//

//
        HomeTurtle h = new HomeTurtle();
        System.out.println(h.toEmailAddress("jozef SUMNY drobny"));
        System.out.println(h.replaceNumbers("AB4 FD","ABCDEFGH"));
        System.out.println(h.sanitize("jjjjjjjjjJJJJ           jjjjjjjjjjjjaaavaaaahoooo"));

        System.out.println(h.countAcronyms("Ahoj ja si FICIM na CBD veciach OD Janka z HOSPODY"));
        System.out.println(h.longestPref("Ab D", "ABCD"));
//        System.out.println(rovnakyObsah);
//		System.out.println(k.sFarbouVon(5));
//		k.kroky(1000);
        // you can put other initialization commands here




        ClickPane cp = new ClickPane();

    }
}