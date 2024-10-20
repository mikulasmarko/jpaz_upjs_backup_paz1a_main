package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

public class HomeTurtle extends Turtle {


    public String longestPref(String s1, String s2) {
        StringBuilder prefix = new StringBuilder();
        int dlzka = Math.min(s1.length(), s2.length());//zistim ktore je kratsie, aby som zbytocne nemusel prechadzat aj to dlhsie
        for (int i = 0; i < dlzka; i++) { //bude prechadzat retazcami kym neprejde tym kratsim, co uplne staci
            if (s1.charAt(i) == s2.charAt(i)) {//porovnavam znaky na rovnakej pozicii, ak sa rovnaku, pridam to do konecneho prefixu
                prefix.append(s1.charAt(i));
            } else {
                return prefix.toString();//zabezpecuje to ze ak sa zrazu prestanu rovnat, vyhodi nas von z cyklu
            }
        }
        return prefix.toString();//ak by sa rovnal cely retazec
    }

    public String toEmailAddress(String name) {
        StringBuilder finalAdress = new StringBuilder();
        for (int i = 0; i < name.length(); i++) { //budem prechadzat retazcom
            if (name.charAt(i) == ' ') {//ak najdem medzeru nahradim ju bodkou a pridam do finalneho retazca
                finalAdress.append('.');//funguje aj ked ma niekto 3 mena
            } else {
                finalAdress.append(name.charAt(i));//ak sa tam nenachadza medzera, pridam dany znak
            }
        }
        finalAdress.append("@upjs.sk");//pridam na koniec retazca koncovku mailu
        return finalAdress.toString().toLowerCase();//vratim retazec s tym ze vsetky pismena budu male
    }

    public int countAcronyms(String r) {
        int counter = 0;
        int finalCount = 0;
        for (int i = 0; i < r.length(); i++) {//budem prechadzat retazcom znak po znaku
            if (r.charAt(i) >= 'A' && r.charAt(i) <= 'Z') {//ak sa bude znak nachadzat medzi A a Z
                counter++;//pripocitam k pocitadlu
                if (counter == 3) {//akonahle budu 3 mam, mam skratku, ak je dlhsie nezvysi mi to celkovy pocet
                    finalCount++;
                }
            } else {//ak nie je dalsie pismeno velke zresetuje pocitadlo
                counter = 0;
            }
        }
        return finalCount;
    }

    public String replaceNumbers(String s, String replacement) {
        StringBuilder sb = new StringBuilder();
        String part = s;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(part.charAt(i))) {//ak zisti ze je na mieste cisl
                sb.append(replacement.charAt(i));//priradi znak z replacement do vysledku

            } else {
                sb.append(part.charAt(i));//ak to nie je cislo tak to priradi do vysledku
            }
        }
        return sb.toString();
    }

    public String sanitize(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) //budem prechadzat retazcom
            if (i == 0) {//prida mi prvy znak do noveho retazca
                sb.append(s.charAt(0));
            } else {
                if (s.charAt(i) == s.charAt(i - 1)) { //ak sa bude rovnnat aktualny s predoslym, preskoci ho
                    continue;
                } else {
                    sb.append(s.charAt(i));//ak sa nerovnaku prida ho do retazca
                }
            }


        return sb.toString();
    }

}
