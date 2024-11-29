package sk.upjs.paz;

import java.util.Arrays;

public class NumberList {
    private int[] number;

    public NumberList() {
        this.number = new int[0];

    }

    public NumberList(int[] numbers) {
        this.number = numbers.clone();
//            this.number = new int[numbers.length];
//            System.arraycopy(numbers, 0, this.number, 0, numbers.length);


    }

    public NumberList(NumberList numberList) {
        this.number=numberList.getNumber();


    }

    public int get(int index) {
        return 0;
    }

    public void set(int index, int value) {
        this.number[index] = value;
    }

    public void add(int value) {
        int[] pomocne = new int[number.length + 1];
        for (int i = 0; i < number.length; i++) {
            pomocne[i] = number[i];

        }
        pomocne[pomocne.length - 1] = value;
        number = pomocne;
    }

    public int size() {
        return number.length;
    }

    public void clear() {
        number = new int[0];
    }

    public int remove(int index) {
        return 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(number);
    }

    public int[] getNumber() {
        return number.clone();
    }

    public void setNumber(int[] number) {
        this.number = number;
    }


}