package sk.upjs.paz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Stanok {

    private ArrayList<Zelenina> mojStanok;


    public Stanok() {
        mojStanok = new ArrayList<>();
    }

    public void eviduj(Zelenina zelenina) {
        mojStanok.add(zelenina);
    }

    public void ulozEvidenciu(String nazovSuboru) throws FileNotFoundException {
        File subor = new File(nazovSuboru);
        PrintWriter printWriter = new PrintWriter(subor);

        for (Zelenina zelenina : mojStanok) {
            printWriter.println(zelenina.toString());
        }
        printWriter.close();

    }

    public static Stanok nacitajEvidenciu(String nazovSuboru) throws FileNotFoundException {
        File subor = new File(nazovSuboru);
        Scanner scanner = new Scanner(subor);
        Stanok st = new Stanok();

        while (scanner.hasNextLine() && scanner.hasNext()) {
            st.eviduj(Zelenina.zoStringu(scanner.nextLine()));
        }
        scanner.close();
        return st;
    }

    @Override
    public String toString() {
        return "Stanok{" +
                "mojStanok=" + mojStanok +
                '}';
    }

    public double nakup(String nazov, String dodavatel, int mnozstvo) {
        for (Zelenina zelenina : mojStanok) {
            if (zelenina.getNazov().equals(nazov) && zelenina.getDodavatel().equals(dodavatel)) {
                if (zelenina.getZostatok() >= mnozstvo) {
                    zelenina.setMnozstvo(zelenina.getMnozstvo() - mnozstvo);
                    return mnozstvo * zelenina.getJednotkovaCena();
                }
            }
        }
        return 0;
    }

    public double pocetExternychDodavatelov() {
        int pocet = 0;
        for (Zelenina zelenina : mojStanok) {
            if (zelenina.getDodavatel().equals("VLASTNA PRODUKCIA")) {
                pocet++;
            }
        }
        return pocet;
    }

    public List<String> zeleninySPoznamkou(String poznamka) {

        List<String> zoznam = new ArrayList<>();

        for (Zelenina zelenina : mojStanok) {
            if (zelenina.getPoznamka().equals(poznamka)) {
                zoznam.add(zelenina.getNazov());
            }
            Collections.sort(zoznam);
        }
        return zoznam;
    }

    public double podielVlastnejProdukcie() {
        double vlastnaCena = 0;
        double celkovaCena = 0;
        for (Zelenina zelenina : mojStanok) {
            celkovaCena = celkovaCena + zelenina.zaplatenaSuma();
            if (zelenina.getDodavatel().equals("VLASTNA PRODUKCIA")) {
                vlastnaCena = vlastnaCena + zelenina.zaplatenaSuma();
            }
        }
        return vlastnaCena * 100 / celkovaCena;
    }

    public Stanok dalsiDen() {
        Stanok dalsi = new Stanok();
        for (Zelenina zelenina : mojStanok) {
            if (zelenina.getMnozstvo() > 0) {
                zelenina.setPoznamka("z predosleho dna");
                zelenina.setJednotkovaCena((double) Math.round(zelenina.getJednotkovaCena() / 2 * 100) / 100);
                dalsi.eviduj(zelenina);
            }
        }

        return dalsi;
    }

    public void balicky(String nazov, String dodavatel, int velkostBalicka, int minZostatok) {
        for (Zelenina zelenina : mojStanok) {
            if (zelenina.getNazov().equals(nazov) && zelenina.getDodavatel().equals(dodavatel) && zelenina.isNaVahu()) {
                if (zelenina.getZostatok() / 1000 > minZostatok) {
                    double kila = zelenina.getZostatok() / 1000 - minZostatok;
                    if (kila / velkostBalicka > 1) {
                        int pocetBalikov = 0;
                        for (int i = 0; i < (int) kila / velkostBalicka; i++) {
                            pocetBalikov++;
                        }
                        zelenina.setZostatok(zelenina.getZostatok() - pocetBalikov * velkostBalicka);
                        mojStanok.add(Zelenina.zoStringu("balicek" + velkostBalicka + "kg " + zelenina.getNazov() + "\t" + true + "\t" + zelenina.getJednotkovaCena() * pocetBalikov * 1000 + "\t" + pocetBalikov + "\t" + "balicek"));
                    }
                }
            }
        }
    }






}
