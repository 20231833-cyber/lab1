package vn.edu.eaut.lab4;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    public App() {
        setTitle("Lab 4 - SwingWorker");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(10, 1, 10, 10));

        JButton b1 = new JButton("Bài 1 - Đồng hồ đếm ngược");
        JButton b2 = new JButton("Bài 2 - Tiến trình tải dữ liệu");
        JButton b3 = new JButton("Bài 3 - Tổng số nguyên tố");
        JButton b4 = new JButton("Bài 4 - Fibonacci");
        JButton b5 = new JButton("Bài 5 - Đếm dòng file");
        JButton b6 = new JButton("Bài 6 - Hủy tác vụ");
        JButton b7 = new JButton("Bài 7 - Tìm từ khóa");
        JButton b8 = new JButton("Bài 8 - Đọc CSV sinh viên");
        JButton b9 = new JButton("Bài 9 - Tải sản phẩm");
        JButton b10 = new JButton("Bài 10 - Quản lý sản phẩm");

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(b10);

        add(panel);

        b1.addActionListener(e -> new CountdownFrame().setVisible(true));
        b2.addActionListener(e -> new ProgressDemoFrame().setVisible(true));
        b3.addActionListener(e -> new PrimeSumFrame().setVisible(true));
        b4.addActionListener(e -> new FibonacciFrame().setVisible(true));
        b5.addActionListener(e -> new FileLineCounterFrame().setVisible(true));
        b6.addActionListener(e -> new CancelTaskFrame().setVisible(true));
        b7.addActionListener(e -> new KeywordSearchFrame().setVisible(true));
        b8.addActionListener(e -> new StudentCsvFrame().setVisible(true));
        b9.addActionListener(e -> new ProductLoadFrame().setVisible(true));
        b10.addActionListener(e -> new ProductManagerFrame().setVisible(true));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new App().setVisible(true));
    }
}