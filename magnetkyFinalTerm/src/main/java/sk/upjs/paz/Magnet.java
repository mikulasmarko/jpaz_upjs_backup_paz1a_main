package sk.upjs.paz;


import java.util.Scanner;

public class Magnet {

    private int year;
    private String title;
    private String countryCode;
    private boolean fragile;
    private int weight;
    private String giver;
    private String text;

    public boolean isFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGiver() {
        return giver;
    }

    public void setGiver(String giver) {
        this.giver = giver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Magnet(int year, String title, String countryCode, boolean fragile, int weight, String giver) {
        this.year = year;
        this.title = title;
        this.countryCode = countryCode;
        this.fragile = fragile;
        this.weight = weight;
        this.giver = giver;
    }

    public Magnet(int year, String title, String countryCode, boolean fragile, int weight, String giver, String text) {
        this.year = year;
        this.title = title;
        this.countryCode = countryCode;
        this.fragile = fragile;
        this.weight = weight;
        this.giver = giver;
        this.text = text;
    }

    public Magnet() {

    }

    public static Magnet fromString(String input) {
        Magnet novy = new Magnet();
        Scanner scanner = new Scanner(input);
        scanner.useDelimiter("\t");

        novy.setYear(scanner.nextInt());
        novy.setTitle(scanner.next());
        novy.setCountryCode(scanner.next());
        novy.setFragile(scanner.nextBoolean());
        novy.setWeight(scanner.nextInt());
        novy.setGiver(scanner.next());
        if (scanner.hasNext()) {
            novy.setText(scanner.next());
        }
        return novy;
    }

    @Override
    public String toString() {
        if (this.getText() != null) {
            return this.getYear() + "\t" + this.getTitle() + "\t" + this.getCountryCode() + "\t" + this.isFragile() + "\t" + this.getWeight() + "\t" + this.getGiver() + "\t" + this.getText();
        } else {
            return this.getYear() + "\t" + this.getTitle() + "\t" + this.getCountryCode() + "\t" + this.isFragile() + "\t" + this.getWeight() + "\t" + this.getGiver();
        }

    }
}