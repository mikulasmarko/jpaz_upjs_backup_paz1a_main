package sk.upjs.paz;

import java.util.*;

public class ZoznamOdberov {

    /**
     * List reprezentujuci zoznam odberov
     */
    private List<Odber> odbery;

    /**
     * Konstruktor zoznamu odberov vytvori prazdny ArrayList
     */
    public ZoznamOdberov() {
        odbery = new ArrayList<>();
    }

    /**
     * Pridavanie odberu do list-u
     *
     * @param o
     */
    public void pridaj(Odber o) {
        odbery.add(o);
    }

    /**
     * Metoda vrati, kolko odberov sa vykonalo na odbernom mieste zdanom parametrom
     *
     * @param odberneMiesto cislo odberneho miesta
     * @return pocet odberov, ktore sa vykonali na odbernom mieste odberneMiesto
     */
    public int pocetOdberovNaMieste(int odberneMiesto) {
        int counter = 0;
        for (Odber odber : odbery) {
            if (odber.getOdberneMiesto() == odberneMiesto) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Metoda vrati zoznam mien pozitivne testovanych. Mena sa nenachadzaju na zozname dupliticne
     *
     * @return zoznam mien pozitivne testovanych, bez duplicit
     */
    public List<String> pozitivneTestovani() {
        Set<String> menaPozitivnych = new TreeSet<>();
        for (Odber odber : odbery) {
            if (odber.getVysledok()) {
                menaPozitivnych.add(odber.getMenoZamestnanca());
            }
        }
        List<String> toCoVracia = new ArrayList<>();

        for (String pozitivnych : menaPozitivnych) {
            toCoVracia.add(pozitivnych);
        }
        // ??? (1 bod)

        // hint: Set
        return toCoVracia;
    }

    /**
     * Metoda vrati priemerny pocet testovanych za den testovania.
     * Ak testujeme v pondelok 30.11. a piatok 4.12., tak sú to dva dni,
     * pocas ktorych sa testovalo.
     *
     * @return priemerny pocet testovanych za den testovania
     */
    public double priemernyPocetTestovZaDenTestovania() {
        HashMap<String, Integer> dayWithNum = new HashMap<>();


        for (Odber o : odbery) {
            if (o.getDatumOdberu() != null) {
                if (dayWithNum.containsKey(o.getDatumOdberu())) {
                    dayWithNum.put(o.getDatumOdberu(), dayWithNum.get(o.getDatumOdberu()) + 1);
                } else {
                    dayWithNum.put(o.getDatumOdberu(), 1);
                }
            }
        }
        double count = 0;
        for (String s : dayWithNum.keySet()) {
            count = count + (dayWithNum.get(s));
        }

        return count / dayWithNum.size();
//        return 0;
    }


    /**
     * Metoda vrati zoznam mien vsetkych testovanych, ktori sa zucastnili odberu v rozmedzi datumov. Mena sa nenachadzaju na zozname dupliticne
     *
     * @param odDatum datum zaciatku, vratane tohto datumu
     * @param doDatum datum konca, vratane tohto datumu
     * @return mena testovanych v rozmedzi datumov
     */
    public List<String> testovaniOdDo(String odDatum, String doDatum) {
        // ??? (1 bod)
        // hint: Pre jednoduchost nepouzivajte triedu Date, ale odporucame datumy prerobit na cislo a pracovat s cislami
        // napr. ak je odDatum "30.11.2020" a doDatum "4.12.2020" a zaujima nas, ci "1.12.2020"
        // je medzi tymito datumami, tak ich prerobime na cisla, 20201130, 20201204, 20201201
        // a zistujeme, ci plati 20201130 <= 20201201 a zaroven 20201201 <= 20201204
        // pozn.: ak chcete znak '.' (bodka) zapisat ako delimiter pre scanner alebo v metode split, tak ju zapisujeme ako "\\." lebo ide o specialny znak
        // pozn.: pri vstupe vzdy plati, ze odDatum <= doDatum
        return null;
    }

    /**
     * Metoda vrati mapu, kde je kazdemu menu priradene kolko testov absolvoval
     *
     * @return mapa osob a ich poctu absolvovanych testov
     */
    public Map<String, Integer> pocetTestovOsoby() {

        HashMap<String, Integer> absolvoval = new HashMap<>();

        for (Odber odber : odbery) {
            absolvoval.put(odber.getMenoZamestnanca(), 0);
        }
        for (Odber o : odbery) {
            absolvoval.put(o.getMenoZamestnanca(), absolvoval.get(o.getMenoZamestnanca()) + 1);
        }
        return absolvoval;
    }

    /**
     * Metoda vrati zoznam mien pozitivne testovanych, ktori mali aspon 2 pozitivne testy. Mena sa nenachadzaju na zozname dupliticne.
     *
     * @return zoznam mien tych, ktori boli pozitivne testovani aspon dvakrat, bez duplicity mien
     */
    public List<String> opakovanePozitivny() {

        HashMap<String, Integer> mapa = new HashMap<>();

        for (Odber odber : odbery) {
            mapa.put(odber.getMenoZamestnanca(), 0);
        }
        for (Odber o : odbery) {
            if (o.getVysledok())
                mapa.put(o.getMenoZamestnanca(), mapa.get(o.getMenoZamestnanca()) + 1);
        }

        List<String> list = new ArrayList<>();
        for (String s : mapa.keySet()) {
            if (mapa.get(s) > 1) {
                list.add(s);
            }
        }
        // ??? (1 bod)
        return list;
    }

    /**
     * Metoda vrati, ci zamestnanec prekonal nakazu. To znamena, ze mal pozitivny test v nejaky den a negativny neskor.
     *
     * @param menoZamestnanca
     * @return
     */
    public boolean prekonalNakazu(String menoZamestnanca) {
        // ??? (1 bod)
        // hint je pri metoda testovanyOdDo
        return false;
    }

    /**
     * Metoda vrati zoznam tych mien z vyberu zamestnancov, ktori este neabsolvovali ziaden odber.
     *
     * @param vyberZamestnancov
     * @return novy zoznam vytvoreny zo zoznamu vyberZamestancov, bez zamestancov, ktori uz absolvovali odber
     */
    public List<String> bezOdberu(List vyberZamestnancov) {
        for (Odber odber : odbery) {
            if (vyberZamestnancov.contains(odber.getMenoZamestnanca())) {
                vyberZamestnancov.remove(odber.getMenoZamestnanca());
            }

        }
        // ??? (1 bod)
        return vyberZamestnancov;
    }

    /**
     * Metoda vrati zoznam mien zamestnancov, ktori mali pocas toho isteho dna pozitivny aj negativny test. Mena sa nenachadzaju na zozname dupliticne.
     *
     * @return zoznam mien tych, ktori pocas jedneho dna mali pozitivny aj negativny test
     */
    public List<String> podozrivoTestovani() {
        // ??? (1 bod)
        // hint: vyuzite dvojicu menoZamestnanca datumOdberu
        return null;
    }

    /**
     * Metoda vrati cislo odberneho miesta, kde sa vykonalo najviac odberov. Ak je takychto pracovisk viac, tak vrati ktorekolvek z nich.
     *
     * @return cislo pracoviska, ktore vykonalo najviac odberov
     */
    public int najvytazenejsiePracovisko() {

        Map<Integer, Integer> mapa = new HashMap<>();

        for (Odber odber : odbery) {
            mapa.put(odber.getOdberneMiesto(), 0);
        }
        for (Odber odber : odbery) {
            mapa.put(odber.getOdberneMiesto(), mapa.get(odber.getOdberneMiesto()) + 1);
        }

        int pocetMaxOdber = 0;
        int pracovisko = 0;


        for (Integer i : mapa.keySet()) {
            if (pocetMaxOdber < mapa.get(i)) {
                pracovisko = i;
                pocetMaxOdber = mapa.get(i);
            }
        }
        return pracovisko;
    }

}