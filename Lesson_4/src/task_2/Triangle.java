package task_2;

public class Triangle implements InfoPrintable{
    private double a;
    private double b;
    private double c;
    private String backgroundColor;
    private String borderColor;

    public Triangle(double a, double b, double c, String backgroundColor, String borderColor){
        this.a = a;
        this.b = b;
        this.c = c;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }


    @Override
    public double getPerimeter() {
        return this.a + this.b + this.c;
    }

    @Override
    public double getSquare() {
        double p = (this.a + this.b + this.c) / 2.0;
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
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
        System.out.println("Характеристика для треугольника со сторонами: " + this.a + ", " + this.b + ", " + this.c + ":");
        InfoPrintable.super.printProperties();
    }
}
