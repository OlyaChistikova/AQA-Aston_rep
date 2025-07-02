package org.example.task_2;

public class Rectangle implements InfoPrintable{
    private double length;
    private double width;
    private String backgroundColor;
    private String borderColor;

    public Rectangle(double length, double width, String backgroundColor, String borderColor){
        this.length = length;
        this.width = width;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }


    @Override
    public double getPerimeter() {
        return (this.length + this.width) * 2.0;
    }

    @Override
    public double getSquare() {
        return this.length * this.width;
    }

    @Override
    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override
    public String getBorderColor() {
        return this.borderColor;
    }

    @Override
    public void printProperties() {
        System.out.println("Характеристика для прямоугольника со сторонами: " + this.length + ", " + this.width + ":");
        InfoPrintable.super.printProperties();
    }
}
