package controllers;

import helpers.DBHelper;
import javax.swing.JOptionPane;
import models.Models_Form;
import views.Edit;

public class Controller_Edit {
    private DBHelper db;
    private Edit view;
    
    public Controller_Edit(Edit view) {
        this.view = view;
        this.db = new DBHelper();
    }
    
    public void updateMood(String timestamp, int moodid) {
        try {
            Models_Form entry = new Models_Form();
            entry.setMood(view.getMood());
            entry.setCatatan(view.getCatatan());
            entry.setLevelMood(view.getLevelMood());
            entry.setTimestamp(timestamp);
            
            if (db.updateMood(moodid, entry)) {
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