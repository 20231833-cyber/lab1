package vn.edu.eaut.lab4;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class KeywordSearchFrame extends JFrame {
    JButton btnChoose = new JButton("Chọn file");
    JButton btnSearch = new JButton("Tìm");
    JTextField txtKeyword = new JTextField();
    JTextArea area = new JTextArea();
    JLabel lbl = new JLabel("Số dòng: 0");
    File file;

    public KeywordSearchFrame() {
        setTitle("Bài 7 - Tìm từ khóa");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel(new BorderLayout());
        p.add(btnChoose, BorderLayout.WEST);
        p.add(txtKeyword, BorderLayout.CENTER);
        p.add(btnSearch, BorderLayout.EAST);

        add(p, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(lbl, BorderLayout.SOUTH);

        btnSearch.setEnabled(false);

        btnChoose.addActionListener(e -> chooseFile());
        btnSearch.addActionListener(e -> search());
    }

    void chooseFile() {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            btnSearch.setEnabled(true);
        }
    }

    void search() {
        String key = txtKeyword.getText().trim().toLowerCase();

        if (key.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập từ khóa!");
            return;
        }

        btnSearch.setEnabled(false);
        area.setText("");

        SwingWorker<Integer, String> worker = new SwingWorker<>() {
            protected Integer doInBackground() throws Exception {
                int count = 0, lineNo = 0;

                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(file),
                                StandardCharsets.UTF_8))) {

                    String line;
                    while ((line = br.readLine()) != null) {
                        lineNo++;

                        if (line.toLowerCase().contains(key)) {
                            count++;
                            publish("Dòng " + lineNo + ": " + line);
                        }
                    }
                }
                return count;
            }

            protected void process(java.util.List<String> lines) {
                for (String s : lines)
                    area.append(s + "\n");
            }

            protected void done() {
                try {
                    lbl.setText("Số dòng: " + get());
                } catch (Exception e) {
                    lbl.setText("Lỗi đọc file");
                }
                btnSearch.setEnabled(true);
            }
        };

        worker.execute();
    }
}