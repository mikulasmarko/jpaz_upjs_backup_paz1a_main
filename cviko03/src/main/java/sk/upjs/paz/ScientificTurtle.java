package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

public class ScientificTurtle extends Turtle {

    public double min(double a, double b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public long power(int n, int k) {
        long num = 1;
        for (int i = 0; i < k; i++) {
            num = num * n;
        }
        return num;
    }

    public long factorial(int n) {
        long result = 1;
        for (int i = 1; i < n; i++) {
            result = result * i;
        }
        return result;
    }

    public int countDivisors(int n) {
        int counter = 1;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                counter += 1;
            }
        }
        return counter;


    }

    public boolean isPrime(int n) {
        boolean jeToTak = false;
            if (countDivisors(n) == 2) {
                jeToTak = true;
            } else {
                jeToTak = false;
            }
        return jeToTak;
    }
}
