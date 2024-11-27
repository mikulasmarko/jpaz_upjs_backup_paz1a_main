package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class fileturtle2 extends Turtle {

    public boolean isWinner(String name, String resultsFilename) {


        File hlasy = new File(resultsFilename);
        Scanner sc = null;
        name = name.toLowerCase();
        int sucetPodlaMena = 0;
        int celkovySucet = 0;
        int number = 0;


        //prvý try catch blok mi spočíta čísla v jednotlivých riadkoch
        //odchytí teda výnimky, ktoré nie su slova
        try {
            sc = new Scanner(hlasy);
            while (sc.hasNextLine()) {
                String riadok = sc.nextLine();
                //súbor rozdelim na jednotlive riadky
                riadok = riadok.toLowerCase();
                String[] rozdelenyRiadok = riadok.split(" ");

                for (int i = 0; i < rozdelenyRiadok.length; i++) {
                    //každý riadok dalej rozdelím na jednotlivé slová
                    //ak "slovo" je číslo zapíšem si ho a breaknem cyklus, keďže predpokladam že jeden riadok obsahuje prave jedno čislo
                    String slovo = rozdelenyRiadok[i];
                    try {
                        number = Integer.parseInt(slovo);
                        break;

                    } catch (NumberFormatException e) {

                    }
                }
                celkovySucet = celkovySucet + number;
            }
        } catch (NumberFormatException e) {

        } catch (FileNotFoundException e) {

            System.out.println("nie je subor");

        }

        // druhý try catch blok mi prečíta riadok a ak sa zhoduje meno so zadaným meno spustí sa for cklus ktorý nájde číslo v riadku
        // vo chvíly ked nájdem číslo zapíšem ho a breaknem
        try {
            sc = new Scanner(hlasy);
            while (sc.hasNextLine()) {
                String riadok = sc.nextLine();
                riadok = riadok.toLowerCase();
                String[] rozdelenyRiadok = riadok.split(" ");

                for (int i = 0; i < rozdelenyRiadok.length; i++) {

                    /*
                     * bool jetoon
                     * votes
                     *
                     * for kazde slovo
                     *   ci slovo je ten typek
                     *     ak hej, tak jetoon true
                     *   ak ne
                     *     tak skusim parsnut do votes a odchytavam, kedy nahodou
                     *
                     * celkovo plus votes
                     * ak jetoon
                     *   tak prirataj aj ku jeho hlasom
                     * */
                    if (rozdelenyRiadok[i].equals(name)) {

                        for (int j = 0; j < rozdelenyRiadok.length; j++) {
                            String slovo = rozdelenyRiadok[j];
                            try {
                                number = Integer.parseInt(slovo);
                                break;

                            } catch (NumberFormatException e) {

                            }
                        }
                        sucetPodlaMena = sucetPodlaMena + number;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("nie je subor");
        }

        // na konci len porovnám a returnnem pravdivostnú hodnotu
        if (sucetPodlaMena > celkovySucet / 2) {
            return true;
        } else {
            return false;
        }

    }




    public String[] vycitanka(int n, int k, String priebeh) {
        //Ty musíš ísť z kola von!
        //Katka, Lenka, Marika, Nikolka
        //Ty(K)-mu(L)-síš(M)-ísť(N)-z ko(K)-la(L)-von(M)
        //7 slabik
        //k-1
        //dostanem string a vraciam pole
        File vycitanka = new File(priebeh);
        Scanner sc = null;
        String[] povodny = new String[n];
        int poradie = -1;
        int pocitadlo =0;



        try {
            sc = new Scanner(vycitanka);
            while (sc.hasNext()) {
                String riadok = sc.nextLine();
                String[] mena = riadok.split(" ");

                //k % n=
                //Marika Katka Lenka Nikolka
                for(int i=0; i<n; i++){
                    for (int j= 0 ; j<k; j++){
                        poradie++;
                        poradie = poradie % n;

                        if (povodny[poradie]!=null){
                            k=k+1;
                            pocitadlo++;
                        }

                    }

                    povodny[poradie]=mena[i];
                    poradie=-1;
                    k=k-pocitadlo;
                    pocitadlo=0;

                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("nie je subor");
        }
        finally {
            if (sc != null) {
                sc.close();
            }
        }


        return povodny;
    }




    public void renameVariables(String inputFilename, String outputFilename){




        Scanner sc = null;
        File vstup = new File(inputFilename);
        File vystup = new File(outputFilename);
        String vnutroZatvorky;
        //String slovo;
        String [] slova;
        String[] nazvy = new String[5];

        try {
            sc = new Scanner(vstup);
            //sc.useDelimiter("\\(" );
            String riadok = sc.nextLine();
            String[] rozdelenyRiadok = riadok.split("\\(");


            for (int i = 0; i< rozdelenyRiadok.length ; i++){
                nazvy[i] = rozdelenyRiadok[i+1];
            }
        }

        catch (FileNotFoundException e){

        }
    }



}