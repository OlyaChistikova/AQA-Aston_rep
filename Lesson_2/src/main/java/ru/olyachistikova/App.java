package ru.olyachistikova;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //printThreeWords();
        //checkSumSign();
        //printColor();
        //compareNumbers();
        //System.out.println("Результат операции по заданию 5: " + checkSumLimit(4, 5));
        //chechPositiveNum(-3);
        //System.out.println("Результат проверки по заданию 7: " + chechNegatineNum(6));
        //printStringCount("Hello, World!", 5);
        //System.out.println("Результат проверки по заданию 9: " + checkLeapYear(2304));
        //changeNumArray();
        //fillArray();
        //revisionArray();
        //revisionDoubleArray();
        //createArray(3, 5);
    }

    public static void printThreeWords() {
        System.out.println("Задание 1");
        String[] arrString = {"Orange", "Banana", "Apple"};
        for (String s : arrString) {
            System.out.println(s);
        }
    }

    public static void checkSumSign() {
        System.out.println("Задание 2");
        int a = 2;
        int b = 3;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        System.out.println("Задание 3");
        int value = 23;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        System.out.println("Задание 4");
        int a = 2;
        int b = 3;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean checkSumLimit(int a, int b) {
        int sum = a + b;
        if (sum >= 10 & sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void chechPositiveNum(int x) {
        System.out.println("Задание 6");
        if (x >= 0) {
            System.out.printf("Число %d положительное", x);
        } else {
            System.out.printf("Число %d отрицательное", x);
        }
    }

    public static boolean chechNegatineNum(int x) {
        if (x >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void printStringCount(String str, int n) {
        System.out.println("Задание 8");
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    public static boolean checkLeapYear(int year) {
        if (year % 4 == 0 & year % 100 != 0 | year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void changeNumArray() {
        System.out.println("Задание 10");
        int[] array = {0, 1, 0, 0, 1, 1, 1, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void fillArray() {
        System.out.println("Задание 11");
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void revisionArray() {
        System.out.println("Задание 12");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void revisionDoubleArray() {
        System.out.println("Задание 13");
        int n = 4;
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            array[i][i] = 1;
            array[i][n - i - 1] = 1;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

    }

    public static void createArray(int len, int initialValue) {
        System.out.println("Задание 14");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        System.out.println(Arrays.toString(array));
    }
}
