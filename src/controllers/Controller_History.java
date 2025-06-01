package controllers;

import helpers.DBHelper;
import views.History;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;
import javax.swing.table.TableColumn;
import models.Models_Form;

public class Controller_History {
    private DBHelper db;
    private History view;

    public Controller_History(History view) {
        this.view = view;
        this.db = new DBHelper();
    }
    
    private void hideColumn(JTable tabel, int index){
        TableColumn kol = tabel.getColumnModel().getColumn(index);
        kol.setMinWidth(0);
        kol.setMaxWidth(0);
        kol.setPreferredWidth(0);
        kol.setWidth(0);
        kol.setResizable(false);
    }

    public void tampilData() {
        try {
            List<Models_Form> entries = db.getMoodsById(view.getUserid()); // DBHelper kembalikan list Models_Form
            DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
            model.setRowCount(0);
            for (Models_Form entry : entries) {
                model.addRow(new Object[]{
                    entry.getMoodid(),
                    entry.getTimestamp(),
                    entry.getMood(),
                    entry.getCatatan(),
                    entry.getLevelMood()
                });
            }hideColumn(view.getTable(),0);
        } catch (Exception e) {
            System.out.println("Error displaying data: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, 
                "Error loading mood history: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void hapusData(int moodid) {
        int selectedRow = view.getTable().getSelectedRow();

        int confirm = JOptionPane.showConfirmDialog(view,
            "Apakah Anda yakin ingin menghapus data ini?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
            String timestamp = model.getValueAt(selectedRow, 1).toString();
            String mood = model.getValueAt(selectedRow, 2).toString();
            String description = model.getValueAt(selectedRow, 3).toString();
            
            // Show confirmation with details
            int finalConfirm = JOptionPane.showConfirmDialog(view,
                "Hapus mood:\nWaktu: " + timestamp + "\nMood: " + mood + "\nCatatan: " + description,
                "Konfirmasi Final",
                JOptionPane.YES_NO_OPTION);
                
            if (finalConfirm == JOptionPane.YES_OPTION) {
                if (db.deleteMood(moodid)) {
                    JOptionPane.showMessageDialog(view, "Data berhasil dihapus.");
                    tampilData(); // Refresh the table
                } else {
                    JOptionPane.showMessageDialog(view, "Gagal menghapus data.");
                    view.setVisible(true);
                }
            }
        }
    }
}