import java.sql.*;
import java.util.ArrayList;
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

    public static List<CityHistory> getCityHistory() throws SQLException{
        List<CityHistory> cityHistories = new ArrayList<>();
        String sql = "SELECT * FROM cityhistory";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet r = statement.executeQuery();
        while (r.next()) {
            Integer ID = r.getInt("historicalDataId");
            Integer IDC = r.getInt("cityId");
            Date date = r.getDate("date");
            Integer tmp = r.getInt("temperature");
            String name = r.getString("cityName");
            cityHistories.add(new CityHistory(ID,  IDC, tmp ,date , name));
        }
        connection.close();
        statement.close();
        r.close();
        return cityHistories;
    }
    public static void addCityHistory(CityHistory city) throws SQLException{
        String sql = "INSERT INTO cityhistory (cityId, temperature, cityName ) VALUES ( ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement s = connection.prepareStatement(sql);
        s.setInt(1, city.getCityId());
        s.setInt(2, city.getTemperature());
        s.setString(3,city.getCityName());
        s.executeUpdate();
        connection.close();
        s.close();
        System.out.println("The CityH Add successfully!");
    }


    public static void searchCityHistory(String cityName) throws SQLException {
        String sql = "SELECT ch.historicalDataId, ch.cityId, ch.date, ch.temperature, c.cityName " +
                     "FROM cityhistory ch " +
                     "JOIN city c ON ch.cityId = c.cityId " +
                     "WHERE ch.cityName = ?";;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cityName);
        ResultSet r = statement.executeQuery();
        while (r.next()){
            Integer ID = r.getInt("historicalDataId");
            Integer IDC = r.getInt("cityId");
            Date DATE = r.getDate("date");
            Integer TMP = r.getInt("temperature");
            String NAME = r.getString("cityName");

            System.out.println("----------------------------");
            System.out.println("ID: " + ID);
            System.out.println("Nom de la ville: " + NAME);
            System.out.println("ID de la ville: " + IDC);
            System.out.println("Date: " + DATE);
            System.out.println("Température: " + TMP);
            System.out.println("-----------------------------");

        }

    }

    public static void modifierH(CityHistory cityHistory) throws SQLException {

        String sql = "UPDATE cityhistory SET cityName = ?, temperature = ? WHERE cityId = ?";
        Connection connection = connection();
        PreparedStatement s = connection.prepareStatement(sql);
        s.setString(1, cityHistory.getCityName());
        s.setInt(2, cityHistory.getTemperature());
        s.setInt(3,cityHistory.getCityId());
        s.executeUpdate();
        connection.close();
        s.close();
        System.out.println("The City updated successfully!");
    }
}
