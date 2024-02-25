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

}
