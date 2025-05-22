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
        String username = view.getUsername();
        ResultSet rs = db.getMoodsByUsername(username);

        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0); // clear

        try {
            while (rs != null && rs.next()) {
                String date = rs.getString("timestamp");
                String mood = rs.getString("mood");
                String desc = rs.getString("catatan");
                int level = rs.getInt("level_mood");
                model.addRow(new Object[]{date, mood, desc, level});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void hapusData() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Pilih data yang ingin dihapus!");
            return;
        }

        String timestamp = view.getTable().getValueAt(selectedRow, 0).toString();
        String username = view.getUsername();

        if (db.deleteMood(timestamp, username)) {
            JOptionPane.showMessageDialog(view, "Data berhasil dihapus.");
            tampilData();
        } else {
            JOptionPane.showMessageDialog(view, "Gagal menghapus data.");
        }
    }
}
