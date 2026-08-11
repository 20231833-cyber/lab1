package vn.edu.eaut.lab4;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciFrame extends JFrame {
    JTextField txtN = new JTextField();
    JButton btnFind = new JButton("Tìm");
    JLabel lblResult = new JLabel("Kết quả: ");
    JProgressBar progress = new JProgressBar(0, 100);

    Map<Integer, BigInteger> memo = new HashMap<>();

    public FibonacciFrame() {
        setTitle("Bài 4 - Fibonacci");
        setSize(450, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(4, 1, 5, 5));
        p.add(new JLabel("Nhập N:"));
        p.add(txtN);
        p.add(btnFind);
        p.add(lblResult);

        add(p, BorderLayout.CENTER);
        add(progress, BorderLayout.SOUTH);

        btnFind.addActionListener(e -> calculate());
    }

    void calculate() {
        int n;

        try {
            n = Integer.parseInt(txtN.getText().trim());
            if (n < 0) throw new Exception();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "N phải là số nguyên >= 0");
            return;
        }

        btnFind.setEnabled(false);
        progress.setValue(0);
        lblResult.setText("Đang tính...");

        SwingWorker<BigInteger, Void> worker = new SwingWorker<>() {
            protected BigInteger doInBackground() {
                return fibonacci(n);
            }

            protected void done() {
                try {
                    lblResult.setText("F(" + n + ") = " + get());
                    progress.setValue(100);
                } catch (Exception e) {
                    lblResult.setText("Có lỗi!");
                }
                btnFind.setEnabled(true);
            }
        };

        worker.execute();
    }

    BigInteger fibonacci(int n) {
        if (n <= 1)
            return BigInteger.valueOf(n);

        if (memo.containsKey(n))
            return memo.get(n);

        BigInteger result = fibonacci(n - 1).add(fibonacci(n - 2));
        memo.put(n, result);

        return result;
    }
}