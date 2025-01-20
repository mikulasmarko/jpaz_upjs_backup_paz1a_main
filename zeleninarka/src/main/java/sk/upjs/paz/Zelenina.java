package sk.upjs.paz;

import java.util.Locale;
import java.util.Scanner;

public class Zelenina implements Comparable<Zelenina> {
    private String nazov;
    private boolean naVahu;
    private double jednotkovaCena;
    private int mnozstvo;
    private String dodavatel;
    private int zostatok;
    private String poznamka;
    public static final String vlastnaPorodukcia = "VLASTNA PRODUKCIA";


    public int getZostatok() {
        return zostatok;
    }

    public void setZostatok(int zostatok) {
        this.zostatok = zostatok;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public boolean isNaVahu() {
        return naVahu;
    }

    public void setNaVahu(boolean naVahu) {
        this.naVahu = naVahu;
    }

    public double getJednotkovaCena() {
        return jednotkovaCena;
    }

    public void setJednotkovaCena(double jednotkovaCena) {
        this.jednotkovaCena = jednotkovaCena;
    }

    public int getMnozstvo() {
        return mnozstvo;
    }

    public void setMnozstvo(int mnozstvo) {
        this.mnozstvo = mnozstvo;
    }

    public String getDodavatel() {
        return dodavatel;
    }

    public void setDodavatel(String dodavatel) {
        this.dodavatel = dodavatel;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public Zelenina(String nazov, boolean naVahu, double jednotkovaCena, int mnozstvo, String dodavatel, int zostatok, String poznamka) {
        this.nazov = nazov;
        this.naVahu = naVahu;
        this.jednotkovaCena = jednotkovaCena;
        this.mnozstvo = mnozstvo;
        this.dodavatel = dodavatel;
        this.zostatok = zostatok;
        this.poznamka = poznamka;
    }

    public Zelenina(String nazov, boolean naVahu, double jednotkovaCena, int mnozstvo, String dodavatel, String poznamka) {
        this.nazov = nazov;
        this.naVahu = naVahu;
        this.jednotkovaCena = jednotkovaCena;
        this.mnozstvo = mnozstvo;
        this.dodavatel = dodavatel;
        this.poznamka = poznamka;
    }

    public static Zelenina zoStringu(String popis) {
        Scanner sc = new Scanner(popis);
        sc.useDelimiter("\t");
        sc.useLocale(Locale.US);

        String nazov = sc.next();
        boolean naVahu = sc.nextBoolean();
        double jednotkovaCena = sc.nextDouble();
        int mnozstvo = sc.nextInt();
        String dodavatel = sc.next();
        if (sc.hasNextInt()) {
            int zostatok = sc.nextInt();
            String poznamka = sc.next();
            return new Zelenina(nazov, naVahu, jednotkovaCena, mnozstvo, dodavatel, zostatok, poznamka);
        } else {
            String poznamka = sc.next();
            return new Zelenina(nazov, naVahu, jednotkovaCena, mnozstvo, dodavatel, poznamka);
        }
    }

    @Override
    public String toString() {
        return nazov + '\t' + naVahu + '\t' + jednotkovaCena + '\t' + mnozstvo + '\t' + dodavatel + '\t' + zostatok + '\t' + poznamka;
    }

    public double zaplatenaSuma() {
        return this.getJednotkovaCena() * (this.getMnozstvo() - this.getZostatok());
    }


    @Override
    public int compareTo(Zelenina o) {
        if (!this.dodavatel.equals(o.getDodavatel())) {
            if (this.dodavatel.equals(vlastnaPorodukcia)) {
                return -1;
            }
            if (o.getDodavatel().equals(vlastnaPorodukcia)) {
                return 1;
            }
        } else {
            this.getNazov().compareTo(o.getNazov());
        }

        return 0;
    }


}
