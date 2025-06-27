package task_2;

public class Circle implements InfoPrintable{
    private double r;
    private String backgroundColor;
    private String borderColor;

    public Circle(double r, String backgroundColor, String borderColor){
        this.r = r;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2.0 * this.r;
    }

    @Override
    public double getSquare() {
        return Math.PI * this.r * this.r;
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
        System.out.println("Характеристика круга с радиусом " + this.r + ":");
        InfoPrintable.super.printProperties();
    }
}
