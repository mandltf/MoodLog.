package helpers;

import controllers.Controller_Login;
import java.sql.*;
import java.util.*;
import models.Models_User;

public class DBHelper {
    private final String dbUrl = "jdbc:mysql://localhost/moodlog";
    private final String user = "root";
    private final String pass = "";
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String query;
    
    public DBHelper(){
        try{
            conn = DriverManager.getConnection(dbUrl, user, pass);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //input user
    public boolean insertUser(String email, String username, String password) {
        boolean success = false;
        try {
            query = "INSERT INTO users (email, username, password) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(query);   // assign ke instance variable
            stmt.setString(1, email);
            stmt.setString(2, username);
            stmt.setString(3, password);

            int rows = stmt.executeUpdate();
            success = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();   // tutup PreparedStatement setelah selesai
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return success;
    }
    
    //ambil data user
    public ResultSet getUserByUsername(String username) {
        try {
            query = "SELECT * FROM users WHERE username = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        // Jangan tutup stmt dan rs di sini karena ResultSet dikembalikan dan akan dipakai di luar
    }
    
    //input mood
    public void insertMood(int userid, Models_User entry) throws SQLException {
        try {
            query = "INSERT INTO moods (id_user, timestamp, mood, catatan, level_mood) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userid);
            stmt.setString(2, entry.getTimestamp());
            stmt.setString(3, entry.getMood());
            stmt.setString(4, entry.getCatatan());
            stmt.setInt(5, entry.getLevelMood());
            stmt.executeUpdate();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Models_User> getMoodsById(int userid) {
        List<Models_User> list = new ArrayList<>();
        query = "SELECT timestamp, mood, catatan, level_mood FROM moods WHERE id_user = ? ORDER BY timestamp DESC";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userid);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Models_User entry = new Models_User();
                entry.setTimestamp(rs.getString("timestamp"));
                entry.setMood(rs.getString("mood"));
                entry.setCatatan(rs.getString("catatan"));
                entry.setLevelMood(rs.getInt("level_mood"));
                list.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public boolean deleteMood(String timestamp, int id_user) {
        try {
            query = "DELETE FROM moods WHERE timestamp = ? AND id_user = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, timestamp);
            stmt.setInt(2, id_user);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean updateMood(int userid, Models_User entry) {
        try {
            query = "UPDATE moods SET mood = ?, catatan = ?, level_mood = ? WHERE id_user = ? AND timestamp = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, entry.getMood());
            stmt.setString(2, entry.getCatatan());
            stmt.setInt(3, entry.getLevelMood());
            stmt.setInt(4, userid);
            stmt.setString(5, entry.getTimestamp());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
