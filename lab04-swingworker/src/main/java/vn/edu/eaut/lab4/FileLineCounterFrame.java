package vn.edu.eaut.lab4;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileLineCounterFrame extends JFrame {
    JButton btnChoose = new JButton("Chọn file");
    JButton btnCount = new JButton("Đếm dòng");
    JLabel lbl = new JLabel("Chưa chọn file");
    JProgressBar progress = new JProgressBar(0, 100);

    File file;

    public FileLineCounterFrame() {
        setTitle("Bài 5 - Đếm số dòng");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(4, 1, 5, 5));
        p.add(btnChoose);
        p.add(btnCount);
        p.add(lbl);
        p.add(progress);

        add(p);

        btnCount.setEnabled(false);

        btnChoose.addActionListener(e -> chooseFile());
        btnCount.addActionListener(e -> countLines());
    }

    void chooseFile() {
        JFileChooser fc = new JFileChooser();

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            lbl.setText("File: " + file.getAbsolutePath());
            btnCount.setEnabled(true);
        }
    }

    void countLines() {
        btnCount.setEnabled(false);
        progress.setValue(0);
        lbl.setText("Đang đọc file...");

        SwingWorker<Integer, Void> worker = new SwingWorker<>() {
            protected Integer doInBackground() throws Exception {
                int lines = 0;

                try (BufferedReader br = Files.newBufferedReader(
                        file.toPath(), StandardCharsets.UTF_8)) {

                    while (br.readLine() != null) {
                        lines++;
                    }
                }

                return lines;
            }

            protected void done() {
                try {
                    lbl.setText("Số dòng: " + get());
                    progress.setValue(100);
                } catch (Exception e) {
                    lbl.setText("Lỗi đọc file!");
                }

                btnCount.setEnabled(true);
            }
        };

        worker.execute();
    }
}