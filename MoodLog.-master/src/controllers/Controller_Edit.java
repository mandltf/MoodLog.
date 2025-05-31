package controllers;

import helpers.DBHelper;
import javax.swing.JOptionPane;
import models.Models_User;
import views.Edit;

public class Controller_Edit {
    private DBHelper db;
    private Edit view;
    
    public Controller_Edit(Edit view) {
        this.view = view;
        this.db = new DBHelper();
    }
    
    public void updateMood(String timestamp, int userid) {
        try {
            Models_User entry = new Models_User();
            entry.setMood(view.getMood());
            entry.setCatatan(view.getCatatan());
            entry.setLevelMood(view.getLevelMood());
            entry.setTimestamp(timestamp);
            
            if (db.updateMood(userid, entry)) {
                JOptionPane.showMessageDialog(view, "Mood berhasil diupdate!");
            } else {
                JOptionPane.showMessageDialog(view, 
                    "Gagal mengupdate mood", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, 
                "Error mengupdate mood: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
} 