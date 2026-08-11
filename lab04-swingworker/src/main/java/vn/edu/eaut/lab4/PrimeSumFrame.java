package vn.edu.eaut.lab4;

import javax.swing.*;
import java.awt.*;

public class PrimeSumFrame extends JFrame {
    JTextField txtN = new JTextField();
    JButton btnCalculate = new JButton("Tính");
    JLabel lblResult = new JLabel("Kết quả: ");
    JProgressBar progressBar = new JProgressBar(0, 100);

    public PrimeSumFrame() {
        setTitle("Bài 3 - Tổng số nguyên tố");
        setSize(450, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(4, 1, 5, 5));
        p.add(new JLabel("Nhập N:"));
        p.add(txtN);
        p.add(btnCalculate);
        p.add(lblResult);

        add(p, BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);

        btnCalculate.addActionListener(e -> calculatePrimeSum());
    }

    private void calculatePrimeSum() {
        int n;

        try {
            n = Integer.parseInt(txtN.getText().trim());
            if (n <= 2) {
                JOptionPane.showMessageDialog(this, "N phải lớn hơn 2");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên hợp lệ");
            return;
        }

        btnCalculate.setEnabled(false);
        progressBar.setValue(0);
        lblResult.setText("Đang tính...");

        SwingWorker<Long, Void> worker = new SwingWorker<>() {
            protected Long doInBackground() {
                long sum = 0;

                for (int i = 2; i < n; i++) {
                    if (isPrime(i))
                        sum += i;

                    setProgress(i * 100 / n);
                }

                return sum;
            }

            protected void done() {
                try {
                    lblResult.setText(
                            "Tổng số nguyên tố < " + n + " = " + get());
                    progressBar.setValue(100);
                } catch (Exception e) {
                    lblResult.setText("Có lỗi!");
                }

                btnCalculate.setEnabled(true);
            }
        };

        worker.addPropertyChangeListener(e -> {
            if ("progress".equals(e.getPropertyName()))
                progressBar.setValue((int) e.getNewValue());
        });

        worker.execute();
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}