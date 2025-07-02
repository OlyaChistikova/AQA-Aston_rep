package org.example.task_1;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = Math.max(food, 0);
    }

    public boolean decreaseFood(int quantity) {
        if (quantity <= food) {
            food -= quantity;
            return true;
        }
        return false;
    }

    public void addFood(int quantity) {
        if (quantity > 0) {
            food += quantity;
        }
    }

    public void getFoodInBowl() {
        System.out.println("В миске осталось еды: " + food);
    }
}
