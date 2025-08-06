package birds;

import animals.Animal;

public class Duck extends Animal {
    public Duck(String name, int age, int weight, String color) {
        super(name, age, weight, color);
    }

    @Override
    public void say(){
        System.out.println("Кря");
    }

    public void fly(){
        System.out.println("Я лечу");
    }
}
