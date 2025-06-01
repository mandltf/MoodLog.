/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import helpers.DBHelper;
import javax.swing.JOptionPane;
import models.Models_Form;
import views.Form;
import views.Login;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;

/**
 *
 * @author mandaa
 */
public class Controller_Form {
    DBHelper help;
    Form form;
    
//    public Controller_Form(Homepage home){
//        this.home = home;
//        help = new DBHelper();
//    }
    
    //ambil input dr form
    public Controller_Form(Form form){
        this.form = form;
        help = new DBHelper();
    }
    
    //fungsi ambil date
    public String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    //ambil mood dr homepage
    public void inputEmot(int userid) {
        try {
            Models_Form entry = new Models_Form();
            entry.setMood(form.getMood());
            entry.setCatatan(form.getCatatan());
            entry.setLevelMood(form.getLevelMood());
            entry.setTimestamp(getCurrentTimestamp());
            entry.setUsername(form.getUsername());

            help.insertMood(userid, entry);
            JOptionPane.showMessageDialog(form, "Mood berhasil disimpan!");
        }catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(form, 
                "Error menyimpan mood: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
}
