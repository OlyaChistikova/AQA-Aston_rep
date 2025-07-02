package org.example.task_1;

public abstract class Animal {
    private String name;
    private static int count;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public abstract void run(int lengthBarrier);

    public abstract void swim(int lengthBarrier);

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}
