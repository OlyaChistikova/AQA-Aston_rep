package org.example;

import org.example.task_1.Product;
import org.example.task_3.Park;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * Задание 1
     * Метод setProduct()
     * создает объект типа Product
     * и выводит информацию о нем в консоль
     */
    public static void setProduct() {
        Product product = new Product("Кукла", "10.12.2005", "Куклодомик", "Франция", 10000.00, true);
        product.printInfoProduct();
    }

    /**
     * Задание 2
     * Метод setArrayProducts()
     * создает массив из 5 товаров типа Product
     * и выводит их в консоль
     */
    public static void setArrayProducts() {
        Product[] products = new Product[5];
        products[0] = new Product("Кукла", "10.12.2005", "Куклодомик", "Франция", 10000.00, true);
        products[1] = new Product("Машинка", "17.04.2023", "Виктор", "Греция", 4200.00, true);
        products[2] = new Product("Паяльник", "09.02.2001", "Витязь", "Россия", 2000.00, true);
        products[3] = new Product("Сумка", "13.02.2025", "Виктория", "Италия", 100000.00, true);
        products[4] = new Product("Кресло", "16.10.2015", "Диванчик", "Россия", 14000.00, true);

        for (Product p : products) {
            System.out.println("Название товара: " + p.getName() + ", Дата производства: " + p.getProductionDate() + ", Производитель:" + p.getManufacture() + ", Страна происхождения: " + p.getOriginCountry() + ", Цена: " + p.getPrice() + ", Состояние бронирования покупателем: " + p.isBookingStatus());
        }
    }

    /**
     * Задание 3
     * Метод setParkAttractionInfo()
     * создает экземпляр класса Park и
     * экземпляр внутреннего класса Attraction
     * и выводит информацию о них в консоль
     */
    public static void setParkAttractionInfo() {
        Park Neverland = new Park("Neverland");
        Park.Attraction attraction = Neverland.new Attraction("Колокольчик", "10:00 - 20:00", "500$");
        attraction.getInfo();
    }
}