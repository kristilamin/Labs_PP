package main.gui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class BDConnection {
    private final String HOST = "jdbc:postgresql://localhost:5432/Cursova";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "1111";
    private Connection connection;
    public BDConnection() throws SQLException {
        connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
    }
    public Connection getConnection() { return connection; }
}