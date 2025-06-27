package task_1;

public class Dog extends Animal{
    private String nameDog;
    private static int count = 0;

    public Dog(String nameDog){
        this.nameDog = nameDog;
        count++;
    }

    public void run(int lengthBarrier) {
        if (lengthBarrier > 0 & lengthBarrier <= 500){
            System.out.println("Собака " + this.nameDog + " пробежал " + lengthBarrier + " м.");
        } else {
            System.out.println("Собака " + this.nameDog + " не может пробежать такое расстояние: " + lengthBarrier + " м.");
        }
    }

    public void swim(int lengthBarrier) {
        if (lengthBarrier > 0 & lengthBarrier <= 10){
            System.out.println("Собака " + this.nameDog + " проплыла " + lengthBarrier + " м.");
        } else {
            System.out.println("Собака " + this.nameDog + " не может проплыть такое расстояние: " + lengthBarrier + " м.");
        }
    }

    public static void getCount() {
        System.out.println("Количество созданных собак: " + count);
    }
}
