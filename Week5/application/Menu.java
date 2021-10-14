package Week5.application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Week5.dao.SportDao;
import Week5.entity.Sport;

public class Menu {

  private SportDao sportDao = new SportDao();
  private Scanner scanner = new Scanner(System.in);
  private List<String> options = Arrays.asList("Display Sports", "Display a Sport", "Create Sport", "Update Sport", "Delete Sport");

  public void start() {
    String selection = "";

    do {
      printMenu();
      selection = scanner.nextLine();

      try {
        if (selection.equals("1")) {
          displaySports();
        } else if (selection.equals("2")) {
          displaySport();
        } else if (selection.equals("3")) {
          createSport();
        } else if (selection.equals("4")) {
          updateSport();
        } else if (selection.equals("5")) {
          deleteSport();
        } else if (selection.equals("-1")) {
          System.out.println("Exiting...");
        } else {
          System.out.println("Invalid input");
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }

      if (!selection.equals("-1")) {
        System.out.println("Press enter to continue...");
        scanner.nextLine();
      }

    } while (!selection.equals("-1"));
  }
  
  private void printMenu() {
    System.out.println("Select an Option: (-1 to exit program)\n------------------------------------------");
    for (int i = 0; i < options.size(); i++) {
      System.out.println(i + 1 + ") " + options.get(i));
    }
  }

  private void displaySports() throws SQLException {
    List<Sport> sports = sportDao.getSports();
    for (Sport sport : sports) {
      System.out.println(sport.getSportId() + ": " + sport.getName());
    }
  }

  private void displaySport() throws SQLException {
    System.out.print("Enter sport name: ");
    String name = scanner.nextLine();
    Sport sport = sportDao.getSportByName(name);
    System.out.println(sport.getSportId() + ": " + sport.getName());
  }

  private void createSport() throws SQLException {
    System.out.print("Enter new sport name: ");
    String name = scanner.nextLine();
    sportDao.addNewSport(name);
  }

  private void updateSport() throws SQLException {
    System.out.println("Enter sport by name to update: ");
    String nameOld = scanner.nextLine();
    System.out.println("Enter new sport name: ");
    String nameNew = scanner.nextLine();
    sportDao.updateSportByName(nameNew, nameOld);
  }

  private void deleteSport() throws SQLException {
    System.out.println("Enter sport by name to delete: ");
    String name = scanner.nextLine();
    sportDao.deleteSportByName(name);
  }
}
