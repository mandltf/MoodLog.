package controllers;

import helpers.DBHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import views.Homepage;
import views.Login;

public class Controller_Login {
    Login loginView;
    DBHelper db;
    
    // Constructor untuk Login
    public Controller_Login(Login view) {
        this.loginView = view;
        db = new DBHelper();
    }
    
    public void login() {
        String username = loginView.getUsername().getText().trim();
        String password = new String(loginView.getPassword().getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginView, "Username dan password tidak boleh kosong!");
            return;
        }

        ResultSet rs = db.getUserByUsername(username);
        try {
            if (rs != null && rs.next()) {
                String correctPassword = rs.getString("password");
                if (password.equals(correctPassword)) {
//                    JOptionPane.showMessageDialog(loginView, "Login berhasil!");
                    
                    // buka Homepage
                    new Homepage(username).setVisible(true);
                    loginView.dispose(); // tutup form login
                } else {
                    JOptionPane.showMessageDialog(loginView, "Password salah!");
                }
            } else {
                JOptionPane.showMessageDialog(loginView, "Username tidak ditemukan!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(loginView, "Terjadi kesalahan saat login!");
        }
    }
}
