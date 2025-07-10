package org.example;

public class Factorial {

    public static int factorial(int x) {
        if (x < 0) throw new IllegalArgumentException("Число должно быть положительное");
        if (x == 1 || x == 0) {
            return 1;
        }
        return x * factorial(x - 1);
    }
}
