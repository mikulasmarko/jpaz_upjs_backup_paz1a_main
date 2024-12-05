package sk.upjs.paz;


import sk.upjs.jpaz2.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Podpriemer {

    int mojeZaporneCisielko;

    public List<Integer> nacitajCisla() {
        List<Integer> mojNovyListik = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int noveCislo = Integer.MAX_VALUE;

        while (noveCislo > 0) {
            System.out.println("daj mi cislo: ");
            noveCislo = sc.nextInt();
            if (noveCislo < 0) {
                mojeZaporneCisielko = noveCislo;
            }
            mojNovyListik.add(noveCislo);
        }
        sc.close();
        return mojNovyListik;
    }

    public boolean overitCiAjZaporne() {

        Scanner sc = new Scanner(System.in);
        Boolean ouYesMamOdpoved = null;
        while (ouYesMamOdpoved == null) {
            System.out.println("chces tam aj zaporne kamo? true/false");
            String chcem = sc.next();
            if (chcem.equals("true")) {
                ouYesMamOdpoved = true;
            } else if (chcem.equals("false")) {
                ouYesMamOdpoved = false;
            }
        }
        // opytame sa pouzivatela
        // otazka - system out println
        // odpoved - scanner system.in
        sc.close();
        return ouYesMamOdpoved;
    }

    public double priemer(List<Integer> cisla, boolean ajZaporne) {



        // pozor na celociselne delenie
        return 0;
    }

    public List<Integer> preriedAZorad(List<Integer> cisla, double priemer) {
        // vraj chcete modifikovat povodny, ale ked to bude tazke tak si vytvorte novy
        // vyberte si ci najprv zoradit alebo preriedit
        // zoradit = sort
        // preriedit = remove
        return null;
    }

    public void vypisCisla(List<Integer> vysledok) {
        System.out.println(vysledok);
    }

    public static void main(String[] args) {
        Podpriemer p = new Podpriemer();

        // 1. nacitat cisla
        List<Integer> cisla = p.nacitajCisla();
        // 2. nejak zistit ci ratame aj to zaporne cislo
        boolean ajZaporne = p.overitCiAjZaporne();
        // 3. nejak vypocitat priemer
        double priemer = p.priemer(cisla, ajZaporne);
        // 4. nejak zoradit cisla a vytriedit (alebo opacne)
        List<Integer> vysledok = p.preriedAZorad(cisla, priemer);
        // 5. nejak vypisat cisla
        p.vypisCisla(vysledok);

    }


}

// co potom:
// ci je setrnejsie sort a potom filter alebo opacne