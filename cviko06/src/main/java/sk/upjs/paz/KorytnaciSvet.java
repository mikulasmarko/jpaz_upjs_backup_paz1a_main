package sk.upjs.paz;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import sk.upjs.jpaz2.*;

public class KorytnaciSvet extends WinPane {
    /**
     * Referencia na pole korytnaciek
     */
    private Turtle[] korytnacky = null;

    /**
     * Inicializacna metoda (konstruktor)
     */
    public KorytnaciSvet() {
        this.korytnacky = new Turtle[0];
    }

    /**
     * Metoda na pridanie korytnacky na zadanych suradniciach
     */
    public void pridajKorytnacku(int x, int y) {
        Turtle novaKorytnacka = new Turtle();
        this.add(novaKorytnacka);
        novaKorytnacka.setPosition(x, y);

        Turtle[] noveKorytnacky = new Turtle[this.korytnacky.length + 1];
        System.arraycopy(this.korytnacky, 0, noveKorytnacky, 0, this.korytnacky.length);
        noveKorytnacky[noveKorytnacky.length - 1] = novaKorytnacka;

        this.korytnacky = noveKorytnacky;
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        if (!(detail.isAltDown() || detail.isControlDown() || detail.isShiftDown())) {
            this.pridajKorytnacku(x, y);
        }
    }

    public void vystrelNaTazisko() {
        double X = 0;
        double Y = 0;
        //vyuzijem cyklus na spocitanie vstkych xovych a yovych suradnic
        for (int i = 0; i < korytnacky.length; i++) {
            double aktualneX = this.korytnacky[i].getX();
            double aktualneY = this.korytnacky[i].getY();
            X = X + aktualneX;
            Y = Y + aktualneY;

        }
        //vydelim suradnice poctom korytnaciek, dostanem hodnoty taziska
        X = X / this.korytnacky.length;
        Y = Y / this.korytnacky.length;
        //kazdu korytnacku si zapamatam kde bola, poslem do taziska a spat
        for (int i = 0; i < korytnacky.length; i++) {
            double povodnaX = this.korytnacky[i].getX();
            double povodnaY = this.korytnacky[i].getY();
            this.korytnacky[i].moveTo(X, Y);
            this.korytnacky[i].setPosition(povodnaX, povodnaY);

        }
    }

    public int[] histogram(double x, double y, double d) {
        //zistim aka bola najvacsia vzdialenost
        double vzdialenostNajdalej = Double.MIN_VALUE;
        for (int i = 0; i < korytnacky.length; i++) {
            if (this.korytnacky[i].distanceTo(x, y) > vzdialenostNajdalej) {
                vzdialenostNajdalej = this.korytnacky[i].distanceTo(x, y);
            }
        }
        //velkost pola zistim tak ze zaokruhlim vzdielenost na cele cisla
        int velkostPola = (int) (vzdialenostNajdalej / d) + 1;
        System.out.println(velkostPola);
        int[] pole = new int[velkostPola];
        //nemusim riesit ci existuje korytnacka nejaka, lebo ak nie
        //vytvori pole s rozmerom 1, a hodnotou 0

        //zistujem v akej sekcii su korytnacky a zvysujem hodnotu v poli podla poctu
        for (int i = 0; i < velkostPola; i++) {
            for (int j = 0; j < korytnacky.length; j++) {
                if (korytnacky[j].distanceTo(x, y) >= i * d && korytnacky[j].distanceTo(x, y) < i * d + d) {
                    pole[i]++;
                }
            }
        }
        //vratim pole
        return pole;
    }

    //toto na testovanie
    public void testHistogram(double x, double y, double d) {
        int[] p = this.histogram(x, y, d);
        System.out.print("histogram(" + x + ", " + y + ", " + d + "): ");
        System.out.println(Arrays.toString(p));
    }


    public void doStvorca(double dlzkaStrany) {
        //overim ci vobec je nejaka
        if (korytnacky == null) {
            return;
        }
        //vytvorim si pomocnu korytnacku a zdvihnem jej perp
        Turtle pomocnik = new Turtle();
        pomocnik.penUp();
        this.add(pomocnik);
        //mam pocitadlo nech viem pristupovat ku korytnackam
        int idKorytnacky = 0;
        //kedze svtorec ma 4 strany, zisti pocet kor na jednu stranu
        int pocetKorNaStranu = korytnacky.length / 4;
        //zisti kolko kor bude na jednej strane
        double dlzkaMedziKorytnackami = dlzkaStrany / (pocetKorNaStranu + 1);

        //cyklus sa opakuje 4 krat lebo stvorec
        for (int j = 0; j < 4; j++) {
            //pomocnika presuniem do rohu stvorca
            pomocnik.step(dlzkaStrany / 2);
            pomocnik.turn(90);
            pomocnik.step(-dlzkaStrany / 2);
            //cyklus na vytvorenie korytnaciek na jednej strane
            for (int i = 0; i < pocetKorNaStranu; i++) {
                pomocnik.step(dlzkaMedziKorytnackami);
                korytnacky[idKorytnacky].setPosition(pomocnik.getPosition());
                idKorytnacky++;
            }
            //vratim pomocnika do stredu a natocim ho
            pomocnik.step(-pocetKorNaStranu * dlzkaMedziKorytnackami);
            pomocnik.step(dlzkaStrany / 2);
            pomocnik.turn(-90);
            pomocnik.step(-dlzkaStrany / 2);
            pomocnik.turn(90);
        }
        //dam ho prec aby nezavadzal
        this.remove(pomocnik);
    }


    public double explozia(double x, double y, double sila) {
        //overim ci neni prazdne
        if (korytnacky == null) {
            return 0;
        }
        //vytvorim si premennu kde si budem zapisovat max odhodenie
        double maxVzdialenostOdhodu = 0;
        //budem prechadzat kazdou kor, zistim jej vzdialenost od explozie, vypocitam odhodenie
        for (int i = 0; i < korytnacky.length; i++) {
            double d = korytnacky[i].distanceTo(x, y);
            double odhodenie = (sila * sila) / (d * d * d * d);
            korytnacky[i].penUp();
            //natocim na vybuch/ potom ju otocim prec od vybuchu a pohnem o odhodenie
            korytnacky[i].setDirectionTowards(x, y);
            korytnacky[i].turn(180);
            korytnacky[i].step(odhodenie);
            //zistujem najvacsie odhodenie
            if (odhodenie > maxVzdialenostOdhodu) {
                maxVzdialenostOdhodu = odhodenie;
            }
        }
        return maxVzdialenostOdhodu;
    }

    public double casDoPrichodu(double x, double y) {
        //overim ci existuju kor
        if (korytnacky == null) {
            return 0;
        }

        double vysledok = 0;

        int idKorytnacky = (int) (Math.random() * (korytnacky.length));
        //zistim v akej vzdialenosti od bodu kor je
        double vzdialost = korytnacky[idKorytnacky].distanceTo(x, y);
        //zistim aky je uhol korytnacky, plus aky je uhol z druhej strany
        double uhol = korytnacky[idKorytnacky].directionTowards(x, y);
        double opacnyUhol = 360 - uhol;
        //kedze mam vratit najkratsiu moznu zaujima ma mensi uhol
        //a kedze sa hybe 1px/s alebo 1stupen/s staci mi ich scitat
        return vzdialost + Math.min(uhol, opacnyUhol);
    }


    public int najblizsiaCoNeniTrafena(boolean[] cinter, int aktualneStriela) {
        double x = this.korytnacky[aktualneStriela].getX();
        double y = this.korytnacky[aktualneStriela].getY();
        double najmensiaVzdialenost = Double.MAX_VALUE;
        //nastavim na nejake cislo ktore nikdy nemoze nastat
        int najblizsieID = -7;
//overujem ktora korytnacka je najblisie a nebola zasiahnuta v boolene
        for (int i = 0; i < korytnacky.length; i++) {
            if (aktualneStriela != i && korytnacky[i].distanceTo(x, y) < najmensiaVzdialenost && !cinter[i]) {
                najmensiaVzdialenost = korytnacky[i].distanceTo(x, y);
                najblizsieID = i;
            }
        }
        //vrati bud id najblizsieho co este nebol zasiahnuty alebo -7 aby nas vyhodilo z cyklu
        return najblizsieID;
    }

    public void prestrelka(int idxPrvehoStrelca, Color farbaStriel) {

        int aktualneStriela = idxPrvehoStrelca;
        boolean[] cintorin = new boolean[korytnacky.length];
        //vytvorim pomocnu metodu co zisti kto je najblizsie a sucasne nebol zasiahnuty
        int idNaKohoStiela = this.najblizsiaCoNeniTrafena(cintorin, aktualneStriela);
        //vytvorim si premenne pre suradnice
        double najblizsiaX;
        double najblizsiaY;
        //vytvorim pomocnu korytnacku pomocou ktorej budem robit ciary
        Turtle pomocnik = new Turtle();
        this.add(pomocnik);
        pomocnik.setPenColor(farbaStriel);
        pomocnik.setPosition(korytnacky[aktualneStriela].getPosition());
        //kym bude platit podmienka ze nie su vystrielany vsetci
        while (idNaKohoStiela != -7) {
            najblizsiaX = korytnacky[idNaKohoStiela].getX();
            najblizsiaY = korytnacky[idNaKohoStiela].getY();
            //natocim pomocnu kor na tu na ktoru sa striela, vystrel urobi pomocna
            this.korytnacky[aktualneStriela].turnTowards(najblizsiaX, najblizsiaY);
            pomocnik.moveTo(najblizsiaX, najblizsiaY);
            //pridam do na cintorin tu co bola zasiahnuta a bude strielat zo zahrobia
            cintorin[idNaKohoStiela] = true;
            //novy strielajuci je ten co bol zasiahnuty
            aktualneStriela = idNaKohoStiela;
            //zistim noveho strielajuceho, ak uz nie je, pomocna funckia vrati -7, vyhodi nas z cyklu
            idNaKohoStiela = najblizsiaCoNeniTrafena(cintorin, aktualneStriela);
        }

        //odstranim nech nezavadzia
        this.remove(pomocnik);
    }


}


