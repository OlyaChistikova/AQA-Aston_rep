package org.example;

import org.example.task_1.Animal;
import org.example.task_1.Bowl;
import org.example.task_1.Cat;
import org.example.task_1.Dog;
import org.example.task_2.Circle;
import org.example.task_2.Rectangle;
import org.example.task_2.Triangle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        // Демонстрация бег/плавание
        Dog barbos = new Dog("Барбос");
        barbos.run(501);
        barbos.swim(4);

        Cat barsik = new Cat("Барсик");
        barsik.run(100);
        barsik.swim(3);

        // Миска и кормление котов
        Cat[] cats = {
                new Cat("Котик1"),
                new Cat("Котик2"),
                new Cat("Котик3")
        };

        Bowl bowl = new Bowl(80); // Начальная еда

        for (Cat cat : cats) {
            cat.eat(bowl, 30);
        }

        bowl.getFoodInBowl();// Сколько осталось еды

        bowl.addFood(10);//Добавляем еду в миску

        cats[2].eat(bowl, 30);//Котик3 снова пытается покушать

        // Вывод информации о сытости
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isFull());
        }

        // Общий счетчик
        System.out.println("Всего животных: " + Animal.getCount());
        System.out.println("Собак: " + Dog.getCount());
        System.out.println("Котов: " + Cat.getCount());

        System.out.println("Задание 2");
        //Создаем фигуры и выводим информацию
        Triangle triangle = new Triangle(2, 3, 4, "Green", "Blue");
        triangle.printProperties();
        Rectangle rectangle = new Rectangle(3, 4, "Red", "Yellow");
        rectangle.printProperties();
        Circle circle = new Circle(4, "Grey", "Black");
        circle.printProperties();
    }
}