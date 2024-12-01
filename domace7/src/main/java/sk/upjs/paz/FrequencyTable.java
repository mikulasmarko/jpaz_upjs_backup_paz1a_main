package sk.upjs.paz;

public class FrequencyTable {


    private FrequencyTable[][] tabulka;
    // ??? Konstruktor + clear + getWordCount: 2 body

    /**
     * Konstruktor: vytvori prazdnu frekvencnu tabulku
     */
    public FrequencyTable() {
        tabulka = new FrequencyTable[0][2];

    }

    /**
     * Vyprazdni obsah tabulky (vratene vlozenych slov)
     */
    public void clear() {

    }

    /**
     * Vrati pocet vyskytov slova. V pripade, ze sa slovo v tabulke nenachadza,
     * vrati 0
     *
     * @param word retazec, ktoreho pocet vyskytov chceme zistit
     * @return pocet vyskytov zadaneho slova (retazca)
     */
    public int getNumberOfOccurrences(String word) {
        // ??? (1 body)
    }

    /**
     * Poznaci novy vyskyt slova vo frekvencnej tabulke (zvysi pocitadlo
     * priradene danemu slovu o 1). Ak take slovo sa v tabulke nenachadza,
     * nastavi pocet jeho vyskytov na 1
     *
     * @param word slovo, ktoreho vyskyt chceme poznacit vo frekvencnej tabulke
     */
    public void addOccurrence(String word) {
        // ??? (2 body)
    }

    /**
     * Vrati pocet slov vo frekvencnej tabulke (vsetky maju nenulovy pocet vyskytov)
     *
     * @return pocet slov vo frekvencnej tabulke
     */
    public int getWordCount() {
        int pocet = 0;
        return pocet;
    }

    /**
     * Vrati slova vo frekvencnej tabulke v novovytvorenom poli retazcov
     *
     * @return referencia na novovytvorene pole retazcov so slovami v tabulke
     */
    public String[] getWords() {
        // ??? (1 bod)
    }


    /**
     * Vrati obsah frekvencnej tabulky ako retazec vo formate
     * [slovo1=pocetVyskytov1, slovo2=pocetVyskytov2]
     */
    public String toString() {
        // ??? (1 bod)
    }
}