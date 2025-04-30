import java.sql.*;

public class CountryDao {
    public void create(int id, String name, String code, int continentId) throws SQLException {
        String sql = "INSERT INTO countries (id, name, code, continent) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, code);
            stmt.setInt(4, continentId);
            stmt.executeUpdate();
        }
    }

    public String findById(int id) throws SQLException {
        String sql = "SELECT name FROM countries WHERE id = ?";
        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? rs.getString("name") : null;
        }
    }

    public Integer findByName(String name) throws SQLException {
        String sql = "SELECT id FROM countries WHERE name = ?";
        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? rs.getInt("id") : null;
        }
    }
}
