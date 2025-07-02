package org.example;

import org.example.task_1.MyArraySizeException;
import org.example.task_2.MyArrayDataException;

public class Main {
    public static void main(String[] args) {
        //Создаем массивы для демонстрации работы
        String[][] array1 = {
                {"11", "12", "13", "14"},
                {"21", "22", "23", "24"},
                {"31", "32", "33", "34"},
                {"41", "42", "43", "44"}
        };
        String[][] array2 = {
                {"11", "12", "13", "14"},
                {"21", "22", "23", "24"},
                {"31", "32", "33", "34"},
                {"41", "42", "X", "44"}
        };
        String[][] array3 = {
                {"11", "12", "13"},
                {"21", "22", "23"},
                {"31", "32", "33"},
                {"41", "42", "X"}
        };

        //Подсчет суммы всех элементов массива
        try {
            int result1 = getExceptionArray(array1);
            System.out.println("Сумма всех элементов массива: " + result1);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        //Поимка MyArrayDataException
        try {
            int result2 = getExceptionArray(array2);
            System.out.println("Сумма всех элементов массива: " + result2);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        //Поимка MyArraySizeException
        try {
            int result3 = getExceptionArray(array3);
            System.out.println("Сумма всех элементов массива: " + result3);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        //Поимка ArrayIndexOutOfBoundsException
        try {
            String str = array1[4][1];
            System.out.println("Значение: " + str);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int getExceptionArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException(4);
        }

        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException(4);
            }
        }

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }

        return sum;
    }
}