package Week5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Week5.entity.Sport;

public class SportDao {

  private Connection connection;
  private final String GET_SPORTS_QUERY = "SELECT * FROM sports";
  private final String GET_SPORT_BY_NAME_QUERY = "SELECT * FROM sports WHERE name = ?";
  private final String CREATE_SPORT_BY_NAME_QUERY = "INSERT INTO sports(name) VALUES (?)";
  private final String UPDATE_SPORT_BY_NAME_QUERY = "UPDATE sports SET name = ? WHERE name = ?";
  private final String DELETE_SPORT_BY_NAME_QUERY = "DELETE FROM sports WHERE name = ?";


  public SportDao() {
    connection = DBConnection.getConnection();
  }

  public List<Sport> getSports() throws SQLException {
    ResultSet rs = connection.prepareStatement(GET_SPORTS_QUERY).executeQuery();
    List<Sport> sports = new ArrayList<Sport>();

    while (rs.next()) {
      sports.add(populateSports(rs.getInt(1), rs.getString(2)));
    }

    return sports;
  }

  private Sport populateSports(int id, String name) {
    return new Sport(id, name);
  }

  public Sport getSportByName(String name) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(GET_SPORT_BY_NAME_QUERY);
    ps.setString(1, name);
    ResultSet rs = ps.executeQuery();
    rs.next();
    return populateSports(rs.getInt(1), rs.getString(2));
  }

  public void addNewSport(String name) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(CREATE_SPORT_BY_NAME_QUERY);
    ps.setString(1, name);
    ps.executeUpdate();
  }

  public void updateSportByName(String nameNew, String nameOld) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(UPDATE_SPORT_BY_NAME_QUERY);
    ps.setString(1, nameNew);
    ps.setString(2, nameOld);
    ps.executeUpdate();
  }

  public void deleteSportByName(String name) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(DELETE_SPORT_BY_NAME_QUERY);
    ps.setString(1, name);
    ps.executeUpdate();
  }
}
