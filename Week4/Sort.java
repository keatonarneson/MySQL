package Week4;

import java.util.Comparator;
import java.util.List;

public class Sort {

  public static void main(String[] args) {
    List<Animal> animals = lambdaSort();

    System.out.println("Lambda method: ");
    animals.forEach(animal -> System.out.println(animal.getName()));

    System.out.println("Method Reference method:");
    animals.forEach(System.out::println);
  }

  private static Animal animal = new Animal();

  static List<Animal> animals = animal.getAnimals();

  static List<Animal> lambdaSort() {

    Comparator<Animal> comp = null;
    comp = (a1, a2) -> Animal.compare(a1, a2);

    animals.sort(comp);

    return animals;
  }
  
  static List<Animal> methodRefSort() {
  
    Comparator<Animal> comp = null;
    comp = Animal::compare;
  
    animals.sort(comp);

    return animals;
  }

}

