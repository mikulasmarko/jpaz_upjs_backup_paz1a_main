package sk.upjs.paz;

import java.util.Arrays;


public class FrequencyTable {

    private Word[] tabulka;

    // ??? Konstruktor + clear + getWordCount: 2 body

    /**
     * Konstruktor: vytvori prazdnu frekvencnu tabulku
     */
    public FrequencyTable() {
        tabulka = new Word[0];
    }

    /**
     * Vyprazdni obsah tabulky (vratene vlozenych slov)
     */
    public void clear() {
        tabulka = new Word[0];
    }

    /**     * Vrati pocet vyskytov slova. V pripade, ze sa slovo v tabulke nenachadza,
     * vrati 0
     *
     * @param word retazec, ktoreho pocet vyskytov chceme zistit
     * @return pocet vyskytov zadaneho slova (retazca)
     */
    public int getNumberOfOccurrences(String word) {
        for (int i = 0; i < tabulka.length; i++) {
            if (word.equals(tabulka[i].getSlovo())) {
                return tabulka[i].getPocet();
            }
        }
        return 0;
    }

    /**
     * Poznaci novy vyskyt slova vo frekvencnej tabulke (zvysi pocitadlo
     * priradene danemu slovu o 1). Ak take slovo sa v tabulke nenachadza,
     * nastavi pocet jeho vyskytov na 1
     *
     * @param word slovo, ktoreho vyskyt chceme poznacit vo frekvencnej tabulke
     */
    public void addOccurrence(String word) {
        for (int i = 0; i < tabulka.length; i++) {
            if (word.equals(tabulka[i].getSlovo())) {
                tabulka[i].setPocet(tabulka[i].getPocet() + 1);
                break;
            }
        }
        this.addNewWord(word);


    }

    public void addNewWord(String noveSlovo) {
        Word[] pomocne = new Word[tabulka.length];
        System.arraycopy(tabulka, 0, pomocne, 0, tabulka.length);
        pomocne[tabulka.length].setSlovo(noveSlovo);
        pomocne[tabulka.length].setPocet(1);
        tabulka = pomocne;

    }


    /**
     * Vrati pocet slov vo frekvencnej tabulke (vsetky maju nenulovy pocet vyskytov)
     *
     * @return pocet slov vo frekvencnej tabulke
     */
    public int getWordCount() {
        int counter = 0;
        for (int i = 0; i < tabulka.length; i++) {
            counter += tabulka[i].getPocet();
        }
        return counter;
    }

    /**
     * Vrati slova vo frekvencnej tabulke v novovytvorenom poli retazcov
     *
     * @return referencia na novovytvorene pole retazcov so slovami v tabulke
     */
    public String[] getWords() {
        String[] poleSlov = new String[tabulka.length];
        for (int i = 0; i < tabulka.length; i++) {
            poleSlov[i] = tabulka[i].getSlovo();
        }
        return poleSlov;
    }


    /**
     * Vrati obsah frekvencnej tabulky ako retazec vo formate
     * [slovo1=pocetVyskytov1, slovo2=pocetVyskytov2]
     */
    public String toString() {
        String retazec = "[";
        for (int i = 0; i < tabulka.length - 1; i++) {
            retazec += tabulka[i].getSlovo() + "=" + tabulka[i].getPocet() + ",";
        }
        retazec += tabulka[tabulka.length - 1].getSlovo() + "=" + tabulka[tabulka.length - 1].getPocet() + "]";
        return retazec;
    }

}