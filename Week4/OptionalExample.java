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
  
  public static Animal methodA(Optional<Animal> optionalAnimal) throws NoSuchElementException {
    if (optionalAnimal.isPresent()) {
      return optionalAnimal.get();
    } else {
      throw new NoSuchElementException("Animal object is missing! (MethodA)");
    }

  }

  public static Animal methodB(Optional<Animal> animal) {

    try {
      // animal.orElseThrow(() -> new NoSuchElementException("Animal Object does not exist (MethodB)"));
      System.out.println(methodA(animal));
      return animal.get();

    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }
}

