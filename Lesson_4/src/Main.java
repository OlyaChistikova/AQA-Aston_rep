import task_1.Animal;
import task_1.Cat;
import task_1.Dog;

public class Main {

    public static void main(String[] args) {
        getTask_1();
    }
    public static void getTask_1(){
        Animal cow = new Animal("Мурка");
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Снежок");
        Dog dog1 = new Dog("Барбос");
        Dog dog2 = new Dog("Мухтар");
        cat1.run(100);
        cat2.swim(3);
        dog1.run(501);
        dog2.swim(4);
        Animal.getCount();
        Cat.getCount();
        Dog.getCount();
        cat1.eat(99);
        cat1.eat(4);
        cat2.eat(14);
        Cat.getFoodInBowl();
        Cat.addFoodInBowl(100);
        Cat.getFoodInBowl();
        getCatArray();
        Cat.getFoodInBowl();
    }

    public static void getCatArray(){
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Котик1");
        cats[1] = new Cat("Котик2");
        cats[2] = new Cat("Котик3");
        cats[3] = new Cat("Котик4");
        cats[4] = new Cat("Котик5");

        for (Cat c : cats){
            c.eat(25);
        }
    }
}
