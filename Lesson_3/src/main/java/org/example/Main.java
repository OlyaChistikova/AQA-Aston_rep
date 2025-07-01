package org.example;

import org.example.task_1.Product;
import org.example.task_3.Park;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("Кукла", "10.12.2005", "Куклодомик", "Франция", 10000.00, true);
        product.printInfoProduct();

        Product[] products = new Product[5];
        products[0] = new Product("Кукла", "10.12.2005", "Куклодомик", "Франция", 10000.00, true);
        products[1] = new Product("Машинка", "17.04.2023", "Виктор", "Греция", 4200.00, true);
        products[2] = new Product("Паяльник", "09.02.2001", "Витязь", "Россия", 2000.00, true);
        products[3] = new Product("Сумка", "13.02.2025", "Виктория", "Италия", 100000.00, true);
        products[4] = new Product("Кресло", "16.10.2015", "Диванчик", "Россия", 14000.00, true);

        for (Product p : products) {
            p.printInfoProduct();
        }

        Park Neverland = new Park("Neverland");
        Park.Attraction attraction = Neverland.new Attraction("Колокольчик", "10:00 - 20:00", "500$");
        attraction.getInfo();
    }
}