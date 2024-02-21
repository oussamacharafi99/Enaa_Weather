import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataConnection {
    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/oussama?serverTimezone=UTC",
                "root",
                ""
        );
    }

    public static Connection getConnection() throws SQLException {
        return connection();
    }

    public static List<City> getCity() throws SQLException{
        List<City> cities = new ArrayList<>();

        String sql = "SELECT * FROM city";

        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet r = statement.executeQuery();

        while (r.next()) {
            Integer id = r.getInt("id");
            String name = r.getString("name");
            Integer temperature = r.getInt("currentTemperature");
            Integer humidity = r.getInt("currentHumidity");
            Integer windSpeed = r.getInt("currentWindSpeed");
            Date dateCity = r.getDate("dateCity");
            cities.add(new City(id, name,temperature, humidity, windSpeed,dateCity));
        }

        connection.close();
        statement.close();
        r.close();

        return cities;

    }

    public static void addCity(City city) throws SQLException{
        String sql = "INSERT INTO city ( cityName, currentTemperature, currentHumidity, currentWindSpeed) VALUES ( ?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement s = connection.prepareStatement(sql);
        s.setString(1, city.getCityName());
        s.setInt(2, city.getCurrentTemperature());
        s.setInt(3, city.getCurrentHumidity());
        s.setInt(4, city.getCurrentWindSpeed());
        s.executeUpdate();
        connection.close();
        s.close();
        System.out.println("The City Add successfully!");
    }
    public static void updateCity(City city) throws SQLException {
        String sql = "UPDATE city SET cityName = ?, currentTemperature = ? ,currentHumidity = ? ,currentWindSpeed = ? WHERE cityId = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, city.getCityName());
        statement.setInt(2, city.getCurrentTemperature());
        statement.setInt(3,city.getCurrentHumidity());
        statement.setInt(4,city.getCurrentWindSpeed());
        statement.setInt(5,city.getCityId());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("Student updated successfully!");
    }
    public static void deleteCity(Integer id) throws SQLException {
        String sql = "DELETE FROM city WHERE cityId = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("Student deleted successfully!");
    }
}
