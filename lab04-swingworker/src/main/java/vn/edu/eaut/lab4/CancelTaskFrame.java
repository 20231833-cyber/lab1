package vn.edu.eaut.lab4;

import javax.swing.*;
import java.awt.*;

public class CancelTaskFrame extends JFrame {
    JButton btnStart = new JButton("Bắt đầu");
    JButton btnCancel = new JButton("Hủy");
    JProgressBar progress = new JProgressBar(0, 100);
    JLabel lbl = new JLabel("Chưa chạy", SwingConstants.CENTER);
    SwingWorker<Void, Void> worker;

    public CancelTaskFrame() {
        setTitle("Bài 6 - Hủy tác vụ");
        setSize(450, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnCancel.setEnabled(false);
        progress.setStringPainted(true);

        JPanel p = new JPanel();
        p.add(btnStart);
        p.add(btnCancel);

        add(lbl, BorderLayout.NORTH);
        add(progress, BorderLayout.CENTER);
        add(p, BorderLayout.SOUTH);

        btnStart.addActionListener(e -> startTask());
        btnCancel.addActionListener(e -> worker.cancel(true));
    }

    void startTask() {
        btnStart.setEnabled(false);
        btnCancel.setEnabled(true);
        lbl.setText("Đang xử lý...");

        worker = new SwingWorker<>() {
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    if (isCancelled()) return null;
                    Thread.sleep(100);
                    setProgress(i);
                }
                return null;
            }

            protected void done() {
                if (isCancelled())
                    lbl.setText("Đã hủy tác vụ");
                else
                    lbl.setText("Hoàn thành");

                btnStart.setEnabled(true);
                btnCancel.setEnabled(false);
            }
        };

        worker.addPropertyChangeListener(e -> {
            if ("progress".equals(e.getPropertyName()))
                progress.setValue((int)e.getNewValue());
        });

        worker.execute();
    }
}