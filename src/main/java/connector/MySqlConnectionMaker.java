package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionMaker implements ConnectionMaker {
    private final String ADDRRESS = "jdbc:mysql://52.79.221.26/cinema";
    private final String USERNAME = "root";
    private final String PASSWORD = "1111";

    @Override
    public Connection makeConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(ADDRRESS, USERNAME, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}














