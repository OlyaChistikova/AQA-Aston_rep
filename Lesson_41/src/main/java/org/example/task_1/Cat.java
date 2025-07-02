package org.example.task_1;

public class Cat extends Animal {
    private String nameCat;
    private static int count = 0;
    private boolean satiety;

    public Cat(String nameCat) {
        super(nameCat);
        this.nameCat = nameCat;
        this.satiety = false;
        count++;
    }

    @Override
    public void run(int lengthBarrier) {
        if (lengthBarrier > 0 & lengthBarrier <= 200) {
            System.out.println("Кот " + this.nameCat + " пробежал " + lengthBarrier + " м.");
        } else {
            System.out.println("Кот " + this.nameCat + " не может пробежать такое расстояние: " + lengthBarrier + " м.");
        }
    }

    @Override
    public void swim(int lengthBarrier) {
        System.out.println("Кот " + this.nameCat + " не умеет плавать.");
    }

    public static int getCount() {
        return count;
    }

    public void eat(Bowl bowl, int foodToEat) {
        if (bowl.decreaseFood(foodToEat)) {
            satiety = true;
            System.out.println("Кот " + this.nameCat + " поел");
        } else {
            System.out.println("В миске недостаточно еды для кота " + this.nameCat);
        }
    }

    public boolean isFull() {
        return satiety;
    }
}
