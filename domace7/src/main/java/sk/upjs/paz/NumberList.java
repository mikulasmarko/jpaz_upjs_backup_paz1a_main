package sk.upjs.paz;

import java.util.Arrays;

/**
 * Trieda realizujuca dynamicke pole (zoznam) cisel.
 */
public class NumberList {
    //Hodnotenie: konstruktory a metody bez uvedeneho hodnotania celkom 3 body
    private int[] nums;

    /**
     * Konstruktor zoznamu cisel - vytvori prazdny zoznam
     */
    public NumberList() {
        nums = new int[0];
    }

    /**
     * Konstruktor zoznamu cisel, pricom zoznam sa inicializuje hodnotami PODLA pola
     *
     * @param numbers pole, podla ktoreho sa ma inicializovat zoznam cisel
     */
    public NumberList(int[] numbers) {
        this.nums = numbers.clone();
    }

    /**
     * Konstruktor zoznamu cisel, pricom zoznam sa inicializuje hodnotami PODLA ineho zoznamu
     *
     * @param numberList zoznam, podla ktoreho sa ma inicializovat zoznam cisel
     */
    public NumberList(NumberList numberList) {
        this.nums = numberList.kopirujPole();
    }

    /**
     * Vrati cislo aktualne ulozene na zadanom indexe v zozname
     *
     * @param index index prvku zoznamu, ktoreho hodnotu chceme vratit
     * @return cislo na zadanom indexe v zozname
     */
    public int get(int index) {
        return nums[index];
    }

    /**
     * Nastavi hodnotu prvku zoznamu na zadanom (uz existujucom) indexe
     *
     * @param index index prvku
     * @param value nova hodnota pre prvom na zadanom indexe
     */
    public void set(int index, int value) {
        nums[index] = value;
    }

    /**
     * Prida na koniec zoznamu novy prvok so zadanou hodnotou
     *
     * @param value hodnota prvku pridaneho na koniec zoznamu
     */
    public void add(int value) {
        int[] pomoc = new int[nums.length + 1];

        System.arraycopy(nums, 0, pomoc, 0, nums.length);
        pomoc[pomoc.length - 1] = value;
        nums = pomoc;
    }

    /**
     * Vrati aktualny pocet prvkov v zozname cisel
     *
     * @return pocet prvkov v zozname cisel
     */
    public int size() {
        return nums.length;
    }

    /**
     * Vyprazdni zoznam
     */
    public void clear() {
        nums = new int[0];
    }

    /**
     * Odstrani zo zoznamu prvok na zadanom indexe a vrati hodnotu odstraneneho prvku
     *
     * @param index index odstranovaneho prvku v zozname
     * @return hodnota odstranovaneho prvku v zozname
     */
    public int remove(int index) {
        int prvok = nums[index];
        int[] pomocny = new int[nums.length - 1];
        System.arraycopy(nums, 0, pomocny, 0, index);
        System.arraycopy(nums, index + 1, pomocny, index, pomocny.length - index);
        nums = pomocny;
        return prvok;
    }

    /**
     * Vrati obsah zoznamu vo forme formatovaneho retazca [prvok1, prvok2, prvok3, prvok4]
     */
    @Override
    public String toString() {
//        String retazec = "";
//        for (int i = 0; i < nums.length - 1; i++) {
//            retazec = retazec + nums[i] + ", ";
//        }
//        retazec = retazec + nums[nums.length - 1];
//        return "[" + retazec + "]";
        //ale ako toto riesenie mi robi presne to iste len to nevie eval zjest
        return Arrays.toString(nums);
    }

    public int[] kopirujPole() {
        return nums.clone();
    }

}
