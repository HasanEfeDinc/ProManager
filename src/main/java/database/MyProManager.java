package database;
import java.sql.*;

// MYSQL DRIVER CONNECTION CONFIGS
public class MyProManager {
    private static final String host = "jdbc:mysql://localhost:3306/MyProManager";
    private static  final String username = "root";
    private static  final String password = "password";

    private static Connection connection;

    public static boolean CREATE_CONNECTION(){
        try {
            connection = DriverManager.getConnection(host, username, password);
            System.out.println("Connected to MySQL database");
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to connect to MySQL database");
            e.printStackTrace();
            return false;
        }
    }


    public static boolean CREATE_CONNECTION(String host,String username, String password){
        try {
            connection = DriverManager.getConnection(host, username, password);
            System.out.println("Connected to MySQL database");
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to connect to MySQL database");
            e.printStackTrace();
            return false;
        }
    }

    public static Connection getConnection(){return connection;}
}
