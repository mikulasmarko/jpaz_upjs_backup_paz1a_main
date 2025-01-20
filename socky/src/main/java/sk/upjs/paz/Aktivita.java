package sk.upjs.paz;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Aktivita implements Comparable<Aktivita> {

    private String datum;
    private String casZaciatku;
    private String casKonca;
    private String oznacenieSiete;
    private double spokojnost;
    private String zariadenie;
    private String partner;

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getCasZaciatku() {
        return casZaciatku;
    }

    public void setCasZaciatku(String casZaciatku) {
        this.casZaciatku = casZaciatku;
    }

    public String getCasKonca() {
        return casKonca;
    }

    public void setCasKonca(String casKonca) {
        this.casKonca = casKonca;
    }

    public String getOznacenieSiete() {
        return oznacenieSiete;
    }

    public void setOznacenieSiete(String oznacenieSiete) {
        this.oznacenieSiete = oznacenieSiete;
    }

    public double getSpokojnost() {
        return spokojnost;
    }

    public void setSpokojnost(double spokojnost) {
        this.spokojnost = spokojnost;
    }

    public String getZariadenie() {
        return zariadenie;
    }

    public void setZariadenie(String zariadenie) {
        this.zariadenie = zariadenie;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public Aktivita(String datum, String casZaciatku, String casKonca, String oznacenieSiete, double spokojnost, String zariadenie) {
        this.datum = datum;
        this.casZaciatku = casZaciatku;
        this.casKonca = casKonca;
        this.oznacenieSiete = oznacenieSiete;
        this.spokojnost = spokojnost;
        this.zariadenie = zariadenie;
    }

    public Aktivita(String datum, String casZaciatku, String casKonca, String oznacenieSiete, double spokojnost, String zariadenie, String partner) {
        this.datum = datum;
        this.casZaciatku = casZaciatku;
        this.casKonca = casKonca;
        this.oznacenieSiete = oznacenieSiete;
        this.spokojnost = spokojnost;
        this.zariadenie = zariadenie;
        this.partner = partner;
    }


    public static Aktivita zoStringu(String popis) {
        Scanner scanner = new Scanner(popis);
        scanner.useLocale(Locale.US);
        scanner.useDelimiter("\t");

        String datum = scanner.next();
        String zaciatok = scanner.next();
        String koniec = scanner.next();
        String oznacenie = scanner.next();
        double spoko = scanner.nextDouble();
        String zariadenie = scanner.next();
        if (scanner.hasNext()) {
            return new Aktivita(datum, zaciatok, koniec, oznacenie, spoko, zariadenie, scanner.next());
        }
        return new Aktivita(datum, zaciatok, koniec, oznacenie, spoko, zariadenie);
    }


    @Override
    public String toString() {
        if (getPartner() == null)
            return this.datum + "\t" + this.casZaciatku + "\t" + casKonca + "\t" + oznacenieSiete + "\t" + spokojnost + "\t" + zariadenie;

        else
            return this.datum + "\t" + this.casZaciatku + "\t" + casKonca + "\t" + oznacenieSiete + "\t" + spokojnost + "\t" + zariadenie + "\t" + partner;
    }

    public int dlzka() {

        Scanner zaciatok = new Scanner(this.casZaciatku);
        Scanner koniec = new Scanner(this.casKonca);
        zaciatok.useDelimiter(":");
        koniec.useDelimiter(":");
        return -((zaciatok.nextInt() * 3600 + zaciatok.nextInt() * 60 + zaciatok.nextInt()) - (koniec.nextInt() * 3600 + koniec.nextInt() * 60 + koniec.nextInt()));
    }

    public List<String> partneri() {
        List<String> list = new ArrayList<>();
        if (this.partner == null) {
            return list;
        }
        Scanner scanner = new Scanner(this.getPartner());
        scanner.useDelimiter(", ");
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        scanner.close();
        return list;
    }

    @Override
    public int compareTo(Aktivita o) {
        return 0;
    }
}
