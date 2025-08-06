import animals.Animal;
import birds.Duck;
import pets.Cat;
import pets.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      List<Animal> animal = new ArrayList<>();

      Scanner scan = new Scanner(System.in);

      boolean menu = true;
      while (menu) {
         System.out.println("Выберите команду");
         System.out.println("add/list/exit");
      String input = scan.next().toUpperCase().trim();

      CommandData command = CommandData.of(input);
      switch (command){
         case ADD -> {
            System.out.println("Введите животное из списка: cat/dog/duck");
            input = scan.next();

            String name;
            int age;
            int weight;
            String color;

            System.out.println("Введите имя животного");
            name = scan.next();
            System.out.println("Введите возраст животного");
            age = Integer.parseInt(scan.next());
            System.out.println("Введите вес животного");
            weight = Integer.parseInt(scan.next());
            System.out.println("Введите цвет животного");
            color = scan.next();

            Animal animals;
            switch (input){
               case "cat" -> animals = new Cat(name, age, weight, color);
               case "dog" -> animals = new Dog(name, age, weight, color);
               case "duck" -> animals = new Duck(name, age, weight, color);
               default -> {
                  System.out.println("Такого животного не существует повторите пожалуйста попытку с существующим животным");
                  animals = null;
               }
            }
            if (animals != null){
               animal.add(animals);
               animals.say();
               System.out.println("Животное добавлено");
            }
         }
         case LIST -> animal.forEach(System.out::println);
         case EXIT -> {
            menu = false;
         }
         default -> System.out.println("Вы ввели неверную команду");
      }
      }
      System.out.println("Завершение программы");
   }
}



