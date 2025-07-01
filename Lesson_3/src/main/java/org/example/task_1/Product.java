package org.example.task_1;

public class Product {
    private String name;
    private String productionDate;
    private String manufacture;
    private String originCountry;
    private double price;
    private boolean bookingStatus;

    public Product(String name, String productionDate, String manufacture, String originCountry, double price, boolean bookingStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacture = manufacture;
        this.originCountry = originCountry;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public void printInfoProduct() {
        System.out.println("Название товара: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель:" + manufacture);
        System.out.println("Страна происхождения: " + originCountry);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования покупателем: " + bookingStatus);
    }
}
