package vn.edu.eaut.lab5.ui;

import vn.edu.eaut.lab5.config.DBHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SanPhamPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    public SanPhamPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel();

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        loadData();
    }

    private void loadData() {
        try {
            Connection conn = DBHelper.getConnection();

            String sql = "SELECT * FROM san_pham";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            int columnCount = rs.getMetaData().getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rs.getMetaData().getColumnName(i));
            }

            while (rs.next()) {
                Object[] row = new Object[columnCount];

                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }

                model.addRow(row);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Lỗi khi tải dữ liệu sản phẩm:\n" + e.getMessage(),
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();
        }
    }
}