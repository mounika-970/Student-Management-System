import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";  // Replace with your MySQL username
    private static final String PASSWORD = "root";  // Replace with your MySQL password

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");  
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection successful.");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found. Ensure MySQL Connector JAR is added to classpath.");
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
        }
        return conn;
    }
}
