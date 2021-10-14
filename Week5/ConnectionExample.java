package Week5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionExample {
  public static void main(String[] args) {
    final String URL = "jdbc:mysql://localhost:3306/employees";
    final String USERNAME = "root";
    final String PASSWORD = "root";
    final String SELECT_QUERY = "SELECT * FROM employees LIMIT 20";

    try {
      Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
      System.out.println("Connected succesfully!");
      Statement statement = conn.createStatement();
      ResultSet rs = statement.executeQuery(SELECT_QUERY);

      while (rs.next()) {
        System.out.println("emp_no: " + rs.getInt(1) + " dob: " + rs.getString(2) + " first_name: " + rs.getString(3));
      }

  } catch (SQLException e) {
      System.out.println("Error connecting to the database.");
      e.printStackTrace();
    }
  }

}
