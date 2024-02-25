import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataConnectionCity {
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
            City city = new City();
            city.setCityId(r.getInt("cityId"));
            city.setCityName(r.getString("cityName"));
            city.setCurrentTemperature( r.getInt("currentTemperature"));
            city.setCurrentHumidity( r.getInt("currentHumidity"));
            city.setCurrentWindSpeed( r.getInt("currentWindSpeed"));
            cities.add(city);
        }
        connection.close();
        statement.close();
        r.close();
        return cities;
    }

    public static void addCity(City city) throws SQLException{
        String sql = "INSERT INTO city ( cityId, cityName, currentTemperature, currentHumidity, currentWindSpeed) VALUES ( ?, ?, ?, ?,?)";
        Connection connection = getConnection();
        PreparedStatement s = connection.prepareStatement(sql);
        s.setInt(1, city.getCityId());
        s.setString(2, city.getCityName());
        s.setInt(3, city.getCurrentTemperature());
        s.setInt(4, city.getCurrentHumidity());
        s.setInt(5, city.getCurrentWindSpeed());
        s.executeUpdate();

        connection.close();
        s.close();
        System.out.println("The City Add successfully!");

    }
    public static void updateCity(City city) throws SQLException {

        String sql = "UPDATE city SET cityName = ?, currentTemperature = ?, currentHumidity = ?, currentWindSpeed = ? WHERE cityId = ?";
        Connection connection = connection();
        PreparedStatement s = connection.prepareStatement(sql);

        s.setString(1, city.getCityName());
        s.setInt(2, city.getCurrentTemperature());
        s.setInt(3,city.getCurrentHumidity());
        s.setInt(4,city.getCurrentWindSpeed());
        s.setInt(5,city.getCityId());
        s.executeUpdate();
        connection.close();
        s.close();
        System.out.println("The City updated successfully!");
    }
    public static void deleteCity(String name) throws SQLException {
        String sql = "DELETE FROM city WHERE cityName = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, name);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("The City deleted successfully!");
    }

    //-------------------------------------------------------//


}
