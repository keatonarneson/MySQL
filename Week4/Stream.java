package Week4;

import java.util.List;
import java.util.stream.Collectors;

public class Stream {
  public static void main(String[] args) {
    List<Animal> animals = Sort.animals;
    
    System.out.println(
      animals.stream()
      .map(Animal::toString)
      .sorted()
      .collect(Collectors.joining(", ")));
  }
}
