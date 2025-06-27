package task_1;

public class Animal {
    private String name;
    private static int count;

    public Animal(String name){
        this.name = name;
        count++;
    }
    public Animal(){}
    public void run(int lengthBarrier){
        System.out.println("Животное" + this.name + "пробежало: " + lengthBarrier + " м.");
    }

    public void swim(int lengthBarrier){
        System.out.println("Животное" + this.name + "проплыло: " + lengthBarrier + " м.");
    }

    public static void getCount(){
        System.out.println("Количество созданных животных: " + count);
    }
}
