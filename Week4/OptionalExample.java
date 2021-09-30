package Week4;

import java.util.NoSuchElementException;
import java.util.Optional; 

public class OptionalExample {
  public static void main(String[] args) throws Exception {
    Animal emptyAnimal = new Animal();
    Animal catAnimal = new Animal("cat");

    Optional<Animal> animal = Optional.of(emptyAnimal);
    Optional<Animal> cat = Optional.of(catAnimal);

    methodB(cat);
    methodB(animal);

    
  }
  
  public static Animal methodA(Optional<Animal> optionalAnimal) throws NoSuchElementException {
    if (optionalAnimal.isPresent()) {
      return optionalAnimal.get();
    } else {
      throw new NoSuchElementException("Animal object is missing!");
    }

    // try {
    //     return optionalAnimal.get();
    //   } catch (NoSuchElementException e) {
    //     System.out.println(e.getMessage());
    //     throw e;
    //   }
  }

  public static Animal methodB(Optional<Animal> animal) {
    // return methodA().find().orElseThrow(() -> new NoSuchElementException(
    //   "NO OBJECT FOUND!!!"
    // ));
    // methodA(Optional<Animal> emptyAnimal)

    // Animal animal = methodA(Optional<Animal> emptyAnimal).orElseThrow(() -> new NoSuchElementException("MethodB exception"));

    try {
      System.out.println(methodA(animal));
      return animal.get();
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }
}

