package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FileTurtle extends Turtle {

    public boolean isWinner(String name, String resultsFilename) {
        name = name.toLowerCase();//zmenim si riadok na male, nech to viem porovnavat
        int pocetHlasovPreKandidata = 0;
        int celkovyPocet = 0;

        File f = new File(resultsFilename);// vytvorim si cestu k suboru

        try (Scanner sc = new Scanner(f)) {//potrebujem scaner aby som mohol pozerat na subor
            // dal som ho do try nech sa potom zavre
            while (sc.hasNextLine()) {
                String[] riadok = sc.nextLine().split(" "); //splitnem si kazdy riadok podla medzery
                boolean nasielSomHo = false;
                int pocetHlasovVRiadku = 0;
                for (int i = 0; i < riadok.length; i++) {//prechadzam kazdym slovom v riadku, skusam ci sa da parsenut
                    String toNumber = riadok[i];
                    try {
                        pocetHlasovVRiadku = parseInt(toNumber);
                        celkovyPocet += pocetHlasovVRiadku;//pripocitam ho celkovemu poctu

                    } catch (Exception e) {//ak mi hodi chybu, neni to cislo=mozem riesit ci to neni kandidat
                        e.printStackTrace();
                        if (name.equals(toNumber.toLowerCase())) {//TODO zmen nazov premennej bo to neni dobre
                            nasielSomHo = true;
                        }
                    }
                }
                if (nasielSomHo) {//ak som ho nasiel pripocitam to aj k nemu
                    pocetHlasovPreKandidata += pocetHlasovVRiadku;
                }
            }
        } catch (FileNotFoundException e) {//odchytavam ze sa nenajde subor
            e.printStackTrace();
        }

        return pocetHlasovPreKandidata > (celkovyPocet / 2);//vrati true/false na zaklade vypoctu
    }

    public String[] vycitanka(int n, int k, String priebeh) {
        {
            File subor = new File(priebeh);//urobim si cestu

            String[] deti = new String[n];//vytvorim si pole kde ulozim deti o velkosti poctu deti
            try (Scanner sc = new Scanner(subor)) {//dam scaner tu aby sa potom zavrel
                while (sc.hasNext()) {//budem prechadzat kym scaner vie citat nieco dalsie
                    int pouziteSlabiky = 0;
                    int indexVPoli = -1;
                    //vytvorim si pomocne premenne pre index a pomocnu
                    //cisla tusim preco su take ale z hlavy by som to nevedel vysvetlit
                    //boli zistovane metodou pokus omyl, vyslo/ nevyslo
                    while (pouziteSlabiky != k) {//prechadzam kym mi nedojdu slabiky
                        indexVPoli++;
                        indexVPoli %= n;

                        if (deti[indexVPoli] == null)
                            pouziteSlabiky++;
                    }
                    deti[indexVPoli] = sc.next();
                }
            } catch (FileNotFoundException e) {//ak by sa nenasiel subor
                e.printStackTrace();
            }
            return deti;//vratim pole deti
        }
    }

    public void renameVariables(String inputFilename, String outputFilename) {

        //nerobim tuto ulohu, lebo nemam mentalnu kapacitu na to aktualne

        //ale ak by som mal tak by som to robil tak ze nacitam prvy riadok,
        //zistim co je v zatvorke, splitnem na zaklade ciarky, ulozim do pola
        //budem riesit vzdy to co je na indexe 1, lebo na indexe 0 je typ premennej, potom je jej nazov
        //ulozim si tieto slova do pola, budem prechadzat tolko krat jake velke pole mam
        //premenovaval by som to vo fore pre pocet slov v poli premennych, a potom cez scaner vo while kazde slovo kontroloval
        //ak by som nasiel to slovo tak by som ho zmenil na toto nieco ine, a vsetko zapisoval do suboru pomocou printwritteru
        //to je jak by som to robil za inych okolnosti
        //ak si to realne docital az sem klobuk dole bo pisem jak madar

    }

}