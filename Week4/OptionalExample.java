package Week4;

import java.util.NoSuchElementException;
import java.util.Optional; 

public class OptionalExample {
  public static void main(String[] args) throws Exception {
    Animal catAnimal = new Animal("cat");

    Optional<Animal> animalEmpty = Optional.empty();
    Optional<Animal> cat = Optional.of(catAnimal);

    System.out.println("Unwrapped Animal Object:");
    methodB(cat);

    System.out.println("Empty Optional:");
    methodB(animalEmpty);
  }
  
  public static Animal methodA(Optional<Animal> optionalAnimal) {
    return optionalAnimal.orElseThrow(() -> new NoSuchElementException("Animal object is missing"));
  }

  public static void methodB(Optional<Animal> animal) {

    try {
      System.out.println(methodA(animal));

    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
  }
}

