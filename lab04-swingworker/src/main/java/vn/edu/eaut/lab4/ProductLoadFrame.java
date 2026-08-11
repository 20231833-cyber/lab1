package vn.edu.eaut.lab4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProductLoadFrame extends JFrame {
    JButton btnLoad = new JButton("Tải sản phẩm");
    JProgressBar progress = new JProgressBar(0, 100);
    JLabel lbl = new JLabel("Chưa tải");
    JTable table = new JTable();

    DefaultTableModel model = new DefaultTableModel(
            new String[]{"Mã SP", "Tên SP", "Đơn giá"}, 0);

    public ProductLoadFrame() {
        setTitle("Bài 9 - Tải sản phẩm");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        table.setModel(model);
        progress.setStringPainted(true);

        add(btnLoad, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel p = new JPanel(new BorderLayout());
        p.add(lbl, BorderLayout.NORTH);
        p.add(progress, BorderLayout.SOUTH);
        add(p, BorderLayout.SOUTH);

        btnLoad.addActionListener(e -> load());
    }

    void load() {
        btnLoad.setEnabled(false);
        model.setRowCount(0);

        SwingWorker<List<Product>, Void> worker = new SwingWorker<>() {
            protected List<Product> doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(50);
                    setProgress(i);
                }

                return List.of(
                        new Product("SP01", "Bàn phím", 250000),
                        new Product("SP02", "Chuột", 150000),
                        new Product("SP03", "Màn hình", 2500000)
                );
            }

            protected void done() {
                try {
                    for (Product p : get())
                        model.addRow(new Object[]{
                                p.ma, p.ten, p.gia
                        });

                    lbl.setText("Tải hoàn tất");
                } catch (Exception e) {
                    lbl.setText("Có lỗi");
                }

                btnLoad.setEnabled(true);
            }
        };

        worker.addPropertyChangeListener(e -> {
            if ("progress".equals(e.getPropertyName()))
                progress.setValue((int)e.getNewValue());
        });

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