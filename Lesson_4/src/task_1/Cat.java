package task_1;

public class Cat extends Animal {
    private String nameCat;
    private static int count = 0;
    private boolean satiety = false;
    private static int foodInBowl = 100;

    public Cat(String nameCat) {
        count++;
        this.nameCat = nameCat;
    }

    public void run(int lengthBarrier) {
        if (lengthBarrier > 0 & lengthBarrier <= 200){
            System.out.println("Кот " + this.nameCat + " пробежал " + lengthBarrier + " м.");
        } else {
            System.out.println("Кот " + this.nameCat + " не может пробежать такое расстояние: " + lengthBarrier + " м.");
        }
    }

    public void swim(int lengthBarrier) {
        System.out.println("Кот " + this.nameCat + " не умеет плавать.");
    }

    public static void getCount() {
        System.out.println("Количество созданных кошек: " + count);
    }

    public void eat(int foodToEat) {
        if (satiety){
            System.out.println("Кот " + this.nameCat + " уже сыт");
        } else if (foodToEat < foodInBowl){
            System.out.println("Кот " + this.nameCat + " поел");
            foodInBowl -= foodToEat;
            satiety = true;
        } else {
            System.out.println("В миске недостаточно еды для кота " + this.nameCat);
        }
    }

    public static void getFoodInBowl() {
        System.out.println("В миске осталось: " + foodInBowl);
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }

    public static void addFoodInBowl(int foodInBowl) {
        Cat.foodInBowl += foodInBowl;
    }
}
