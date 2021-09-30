package Week4;

import java.util.NoSuchElementException;
import java.util.Optional; 

public class OptionalExample {
  public static void main(String[] args) {
    Animal emptyAnimal = new Animal();
    Optional<Animal> animal = Optional.of(emptyAnimal);

    <Optional> emptyAnimal = animal;

  }
  
  public Animal methodA(Optional<Animal> optionalAnimal) throws Exception {
    if (optionalAnimal.isEmpty()) {
      throw new Exception("Animal object is missing!");
    } else {
      return optionalAnimal.get();
    }

  }

  // This is just fill in code for now until I get methodA working and is most likely incorrect
  public Animal methodB() {
    // return methodA().find().orElseThrow(() -> new NoSuchElementException(
    //   "NO OBJECT FOUND!!!"
    // ));
    methodA(Optional<Animal> emptyAnimal)
    try {

    } catch (Exception e) {
      //TODO: handle exception
    }
  }
}

