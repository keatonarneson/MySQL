package Week4;

import java.util.ArrayList;
import java.util.List;

public class Animal {
  private String name;

  public Animal() {

  }

  public Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    return name + " Animal";
  }

  public static int compare(Animal a1, Animal a2) {
    return a1.name.compareTo(a2.name);
  }

  public List<Animal> getAnimals() {
    List<Animal> animals = new ArrayList<Animal>();

    animals.add(new Animal("Dog"));
    animals.add(new Animal("Cow"));
    animals.add(new Animal("Cat"));
    animals.add(new Animal("Horse"));

    return animals;
  }

}
