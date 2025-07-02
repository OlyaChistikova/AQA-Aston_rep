package org.example.task_2;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(int row, int column, String value) {
        super("Ошибка в ячейке [" + row + "][" + column + "]: " + value + " не является числом.");
    }
}
