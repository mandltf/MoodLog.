/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import helpers.DBHelper;
import javax.swing.JOptionPane;
import views.Form;
import views.Login;

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
    
    //ambil mood dr homepage
    public void inputEmot(){
        String mood = form.getMood();
        String catatan = form.getCatatan();
        int level = form.getLevelMood();

        help.insertMood(mood, catatan, level); 
        JOptionPane.showMessageDialog(form, "Mood berhasil disimpan!");
        
    }
    
    
}
