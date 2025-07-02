package org.example.task_1;

public class MyArraySizeException extends Exception {

    public MyArraySizeException(int n) {
        super("Массив должен быть размером " + n + "x" + n);
    }
}
