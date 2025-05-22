package controllers;

import helpers.DBHelper;
import javax.swing.JOptionPane;
import models.Models_User;
import views.SignUp;
import java.sql.*;
import views.Login;

/**
 *
 * @author manda
 */
public class Controller_User {
    SignUp view;
    DBHelper db;

    // Constructor untuk Sign Up
    public Controller_User(SignUp view) {
        this.view = view;
        db = new DBHelper();
    }
    
    public void register() {
        String username = view.getUsername().getText().trim();
        String email = view.getEmail().getText().trim();
        String password = new String(view.getPassword().getPassword()).trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Semua field harus diisi!");
            return;
        }

        boolean success = db.insertUser(email, username, password);
        if (success) {
            JOptionPane.showMessageDialog(view, "Registrasi berhasil!");
            view.dispose(); // tutup form signup
            
            // aktifkan form Login
            new Login().setVisible(true); 
        } else {
            JOptionPane.showMessageDialog(view, "Registrasi gagal!");
        }
    }
    
    
}
