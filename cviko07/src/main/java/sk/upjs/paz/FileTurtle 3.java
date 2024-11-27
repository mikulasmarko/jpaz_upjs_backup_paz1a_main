package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileTurtle2 extends Turtle {
    public boolean isWinner(String name, String resultsFilename){
        File file = new File(resultsFilename);
        Scanner sc = null;
        boolean isCandidate;
        int countryVote;
        int totalVotes = 0;
        int candidateVotes = 0;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                // Prejdeme každým riadkom súboru, daný riadok prepíšeme na malé písmená a rozdelíme ho podľa medzier
                String[] words = sc.nextLine().toLowerCase().split(" ");
                isCandidate = false;
                countryVote = 0;

                for (int i = 0; i < words.length; i++) {
                    // Pre každé slovo z riadka skontrolujeme, či sa rovná nášmu hľadanému kandidátovi, ak áno, zaznamenáme si to do premennej
                    if (words[i].equals(name.toLowerCase())) {
                        isCandidate = true;
                    }
                    // Keďže nevieme, na ktorom indexe sa nachádza počet hlasov, pokúsime sa každé slovo parsnuť na int, avšak musíme odchytiť exception
                    try {
                        countryVote = Integer.parseInt(words[i]);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                }

                // Na konci cyklu môžeme predpokladať, že máme počet hlasov a informáciu o tom, či patria hľadanému kandidátovi, ak áno, pripočítame mu ich
                totalVotes += countryVote;
                if (isCandidate) {
                    candidateVotes += countryVote;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        // Zistíme, či má kandidát nadpolovičný počet hlasov
        return candidateVotes > totalVotes/2;
    }

    public String[] vycitanka(int n, int k, String priebeh)
    {
        File file = new File(priebeh);
        Scanner sc = null;
        String[] kids = new String[n];

        try {
            sc = new Scanner(file);
            // Prejdeme každým slovom v súbore
            while (sc.hasNext())
            {
                int i = -1;
                int x = 0;
                // Simuláciu vyčítanky urobíme tak, že budeme ručne "ukazovať" na konkrétne indexy pôvodnej zostavy, avšak ak sa na danom indexe už bude nachádzať meno
                // tak pripočítanie skipneme, kedže daný človek bol už vyradený z hry, to robíme, pokial sa náš súčet nerovná počtu slabík
                while(x != k)
                {
                    i++;
                    // Keďže i používame ako index poľa a môžeme prejsť viac kôl, index sa bude rovnať zvyšku po delení počtom prvkov
                    i %= n;

                    if (kids[i] == null)
                        x++;
                }
                // Na konci sme tak zistili, kde sa nachádzal človek, ktorý bol vyradený a jeho meno tam vložíme
                kids[i] = sc.next();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return kids;
    }


    public void renameVariables(String inputFilename, String outputFilename)
    {
        File input = new File(inputFilename);
        File output = new File(outputFilename);
        Scanner sc = null;
        PrintWriter pw = null;

        try {
            sc = new Scanner(input);
            pw = new PrintWriter(output);
            // Podľa zadania predpokladáme, že budeme mať maximálne 5 premenných, ktorým budeme meniť meno
            String[] variables = new String[5];

            if (sc.hasNextLine()) {
                // Načítame si prvý riadok
                String line = sc.nextLine();
                // Kedže na prvom riadku sa nachádza nazov funkcie aj s parametrami a nás zaujímajú len dané parametre, rozdelíme si tento riadok podľa zátvoriek
                // Na rozdelenie využijeme regex, hranaté zátvorky nám hovoria, že sa string rozdelí tam, kde nájde niečo z obsahu zázvoriek, čo budú v našom prípade
                // ľavá a pravá okrúhla zátvorka
                String[] split = line.split("[()]");
                // Kedže všetko pred ľavou zátvorkou sa nachádza na nultom indexe, na prvom indexe bude obsah zátvoriek, čiže nami hľadané argumenty funkcie, keďže sme
                // splitli aj podľa pravej zátvorky, vieme, že sa tam nebude nachádzať a všetko za ňou bude na druhom indexe
                // Tieto argumenty sú rozdelené čiarkou, takže ak chceme získať jednotlivé argumenty, musíme ich podľa čiarky rozdeliť
                split = split[1].split(",");

                for (int i = 0; i < split.length; i++) {
                    // Prejdeme každým argumentom, odstránime z neho zbytočné medzery, ktoré vznikli pri rozdelení podľa čiarky a kedže sa chceme len názov argumentu
                    // bez jej typu, rozdelíme ho podľa medzery, pričom hľadaný názov sa bude nachádzať na prvom indexe, tento názov si uložíme do poľa, s ktorým budeme pracovať
                    variables[i] = split[i].trim().split(" ")[1];
                }

                while (sc.hasNextLine()) {
                    // Najprv pracujeme s prvým riadkom a potom s každým ďalším
                    // Premenované premenné budu mať názov písmen v abecede
                    char newVar = 'a';
                    for (int i = 0; i < split.length; i++) {
                        // Pre každý názov argumentu, ktorý sme odchytili ho skúsíme v danom riadku vymeniť za prislúchajúce písmeno abecedy,
                        // Kedže replaceAll berie iba Stringy a my pracujeme s charom, pretypujeme ho pomocou valueOf
                        line = line.replaceAll(variables[i], String.valueOf(newVar));
                        // Keďže vieme, že argumenty v poli variables sú zoradené tak, ako sme ich našli, každý ďalší premenujeme tak, že sa posunieme o jedno písmeno v abecede
                        // Keďže char uchováva ASCII kód znaku, posunúť sa vieme pripočítaním jednotky ku charakteru
                        newVar += 1;
                    }

                    pw.println(line);

                    line = sc.nextLine();
                }

                // Kedže sa cyklus pre posledný riadok nespustí a očakávame bežné formátovanie kódu, na ktorom bude iba kučeravá zátvorka, tento riadok iba dopíšeme na koniec
                pw.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }
}
