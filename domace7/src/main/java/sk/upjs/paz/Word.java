package sk.upjs.paz;

public class Word{
    private String slovo;
    private int pocet;


    public Word(String slovo, int pocet) {
        this.slovo = slovo;
        this.pocet = pocet;
    }

    public String getSlovo() {
        return slovo;
    }

    public void setSlovo(String slovo) {
        this.slovo = slovo;
    }

    public int getPocet() {
        return pocet;
    }

    public void setPocet(int pocet) {
        this.pocet = pocet;
    }
}
