package controllers;

import helpers.DBHelper;
import views.History;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Controller_History {
    private DBHelper db;
    private History view;

    public Controller_History(History view) {
        this.view = view;
        this.db = new DBHelper();
    }

    public void tampilData() {
        try {
            ResultSet rs = db.getMoodsByUsername(view.getUsername());
            DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
            model.setRowCount(0); // Clear existing data

            while (rs != null && rs.next()) {
                String date = rs.getString("timestamp");
                String mood = rs.getString("mood");
                String desc = rs.getString("catatan");
                int level = rs.getInt("level_mood");
                model.addRow(new Object[]{date, mood, desc, level});
            }
            
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Error displaying data: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, 
                "Error loading mood history: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void hapusData() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Pilih data yang ingin dihapus!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(view,
            "Apakah Anda yakin ingin menghapus data ini?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            String timestamp = view.getTable().getValueAt(selectedRow, 0).toString();
            if (db.deleteMood(timestamp, view.getUsername())) {
                JOptionPane.showMessageDialog(view, "Data berhasil dihapus.");
                tampilData(); // Refresh the table
            } else {
                JOptionPane.showMessageDialog(view, "Gagal menghapus data.");
            }
        }
    }
}
