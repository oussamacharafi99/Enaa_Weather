import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataConnectionCityHistory {
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

}
