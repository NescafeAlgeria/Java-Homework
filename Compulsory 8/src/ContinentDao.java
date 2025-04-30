import java.sql.*;

public class ContinentDao {
    public void create(int id, String name) throws SQLException {
        String sql = "INSERT INTO continents (id, name) VALUES (?, ?)";
        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.executeUpdate();
        }
    }

    public String findById(int id) throws SQLException {
        String sql = "SELECT name FROM continents WHERE id = ?";
        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? rs.getString("name") : null;
        }
    }

    public Integer findByName(String name) throws SQLException {
        String sql = "SELECT id FROM continents WHERE name = ?";
        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? rs.getInt("id") : null;
        }
    }
}
