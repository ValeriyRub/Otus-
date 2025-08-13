import animals.Animal;
import fabric.AnimalFabric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      List<Animal> animal = new ArrayList<>();

      Scanner scan = new Scanner(System.in);

      while (true) {
         System.out.println("Выберите команду");
         System.out.println("add/list/exit");
      String input = scan.next().toUpperCase().trim();

      CommandData command = CommandData.of(input);
      switch (command){
         case ADD -> {

            while (true) {
               System.out.println("Введите животное из списка: cat/dog/duck");
               input = scan.next().toLowerCase().trim();

               if (!input.equals("cat") && !input.equals("dog") && !input.equals("duck")) {
                  System.out.println("Такого животного не существует. Повторите попытку.");
               } else {
                  break;
               }
            }

            switch (input) {
               case "cat", "dog", "duck" -> {
                  String name;
                  int age;
                  int weight;
                  String color;

                  System.out.println("Введите имя животного");
                  name = scan.next();
                  while (true) {
                     System.out.println("Введите возраст животного");
                     String ageInput = scan.next();
                     try {
                        age = Integer.parseInt(ageInput);
                        if (age <= 0) {
                           System.out.println("Возраст должен быть положительным числом.");
                        } else {
                           break;
                        }
                     } catch (NumberFormatException e) {
                        System.out.println("Ошибка: возраст должен быть числом. Повторите ввод.");
                     }
                  }
                  while (true) {
                     System.out.println("Введите вес животного");
                     String weightInput = scan.next();
                     try {
                        weight = Integer.parseInt(weightInput);
                        if (weight <= 0) {
                           System.out.println("Вес должен быть положительным числом.");
                        } else {
                           break;
                        }
                     } catch (NumberFormatException e) {
                        System.out.println("Ошибка: вес должен быть числом. Повторите ввод.");
                     }
                  }
                  System.out.println("Введите цвет животного");
                  color = scan.next();

                  Animal animals = AnimalFabric.createAnimal(input, name, age, weight, color);
                  if (animals == null) {
                     System.out.println("Такого животного не существует. Повторите попытку.");
                     break;
                  }

                  animal.add(animals);
                  animals.say();
                  if (animals instanceof birds.Flying flyingAnimal) {
                     flyingAnimal.fly();
                  }
                  System.out.println("Животное добавлено");
               }
            }
         }

         case LIST -> animal.forEach(System.out::println);
         case EXIT -> {
            System.out.println("Завершение программы");
            System.exit(0);

         }
         default -> System.out.println("Вы ввели неверную команду");
      }
      }
   }
}



