import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public boolean authenticate(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password =?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();  // Returns true if user exists
        } catch (SQLException e) {
            System.err.println("Authentication failed: " + e.getMessage());
        }
        return false;
    }
}
