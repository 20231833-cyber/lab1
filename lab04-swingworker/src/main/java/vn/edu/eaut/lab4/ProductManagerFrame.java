package vn.edu.eaut.lab4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class ProductManagerFrame extends JFrame {
    JTextField txtMa = new JTextField();
    JTextField txtTen = new JTextField();
    JTextField txtGia = new JTextField();

    JButton btnAdd = new JButton("Thêm");
    JButton btnEdit = new JButton("Sửa");
    JButton btnDelete = new JButton("Xóa");
    JButton btnSave = new JButton("Lưu CSV");
    JButton btnOpen = new JButton("Đọc CSV");

    DefaultTableModel model = new DefaultTableModel(
            new String[]{"Mã SP", "Tên SP", "Đơn giá"}, 0);

    JTable table = new JTable(model);
    ArrayList<Product> list = new ArrayList<>();

    public ProductManagerFrame() {
        setTitle("Bài 10 - Quản lý sản phẩm CSV");
        setSize(750, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel input = new JPanel(new GridLayout(2, 3));
        input.add(new JLabel("Mã SP"));
        input.add(new JLabel("Tên SP"));
        input.add(new JLabel("Đơn giá"));
        input.add(txtMa);
        input.add(txtTen);
        input.add(txtGia);

        JPanel buttons = new JPanel();
        buttons.add(btnAdd);
        buttons.add(btnEdit);
        buttons.add(btnDelete);
        buttons.add(btnSave);
        buttons.add(btnOpen);

        JPanel top = new JPanel(new BorderLayout());
        top.add(input, BorderLayout.CENTER);
        top.add(buttons, BorderLayout.SOUTH);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnAdd.addActionListener(e -> add());
        btnEdit.addActionListener(e -> edit());
        btnDelete.addActionListener(e -> delete());
        btnSave.addActionListener(e -> save());
        btnOpen.addActionListener(e -> open());

        table.getSelectionModel().addListSelectionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) {
                txtMa.setText(model.getValueAt(r, 0).toString());
                txtTen.setText(model.getValueAt(r, 1).toString());
                txtGia.setText(model.getValueAt(r, 2).toString());
            }
        });
    }

    Product getInput() {
        try {
            String ma = txtMa.getText().trim();
            String ten = txtTen.getText().trim();
            long gia = Long.parseLong(txtGia.getText().trim());

            if (ma.isEmpty() || ten.isEmpty() || gia < 0)
                throw new Exception();

            return new Product(ma, ten, gia);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!");
            return null;
        }
    }

    void add() {
        Product p = getInput();
        if (p != null) {
            list.add(p);
            refresh();
        }
    }

    void edit() {
        int r = table.getSelectedRow();
        Product p = getInput();

        if (r >= 0 && p != null) {
            list.set(r, p);
            refresh();
        }
    }

    void delete() {
        int r = table.getSelectedRow();

        if (r >= 0) {
            list.remove(r);
            refresh();
        }
    }

    void refresh() {
        model.setRowCount(0);

        for (Product p : list)
            model.addRow(new Object[]{p.ma, p.ten, p.gia});
    }

    void save() {
        JFileChooser fc = new JFileChooser();

        if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
            return;

        File file = fc.getSelectedFile();

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            protected Void doInBackground() throws Exception {
                try (BufferedWriter w = Files.newBufferedWriter(
                        file.toPath(), StandardCharsets.UTF_8)) {

                    w.write("MaSP,TenSP,DonGia\n");

                    for (Product p : list)
                        w.write(p.ma + "," + p.ten + "," + p.gia + "\n");
                }

                return null;
            }

            protected void done() {
                JOptionPane.showMessageDialog(
                        ProductManagerFrame.this,
                        "Lưu CSV thành công!");
            }
        };

        worker.execute();
    }

    void open() {
        JFileChooser fc = new JFileChooser();

        if (fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
            return;

        File file = fc.getSelectedFile();

        SwingWorker<ArrayList<Product>, Void> worker = new SwingWorker<>() {
            protected ArrayList<Product> doInBackground() throws Exception {
                ArrayList<Product> result = new ArrayList<>();

                try (BufferedReader br = Files.newBufferedReader(
                        file.toPath(), StandardCharsets.UTF_8)) {

                    br.readLine();

                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] a = line.split(",");

                        if (a.length >= 3)
                            result.add(new Product(
                                    a[0].trim(),
                                    a[1].trim(),
                                    Long.parseLong(a[2].trim())));
                    }
                }

                return result;
            }

            protected void done() {
                try {
                    list = get();
                    refresh();

                    JOptionPane.showMessageDialog(
                            ProductManagerFrame.this,
                            "Đọc CSV thành công!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(
                            ProductManagerFrame.this,
                            "Lỗi đọc CSV!");
                }
            }
        };

        worker.execute();
    }

    static class Product {
        String ma, ten;
        long gia;

        Product(String ma, String ten, long gia) {
            this.ma = ma;
            this.ten = ten;
            this.gia = gia;
        }
    }
}