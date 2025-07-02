package org.example.task_2;

public interface InfoPrintable {
    double getPerimeter();
    double getSquare();
    String getBackgroundColor();
    String getBorderColor();

    default void printProperties(){
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getSquare());
        System.out.println("Цвет заливки: " + getBackgroundColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }
}
