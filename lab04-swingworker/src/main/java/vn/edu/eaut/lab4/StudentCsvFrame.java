package vn.edu.eaut.lab4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class StudentCsvFrame extends JFrame {

    JButton btnOpen = new JButton("Đọc CSV");

    JTable table = new JTable();

    DefaultTableModel model = new DefaultTableModel(
            new String[]{"Mã SV", "Họ tên", "Điểm"}, 0);

    JLabel lbl = new JLabel("Điểm TB: ");

    public StudentCsvFrame() {
        setTitle("Bài 8 - Đọc CSV sinh viên");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        table.setModel(model);

        add(btnOpen, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(lbl, BorderLayout.SOUTH);

        btnOpen.addActionListener(e -> openFile());
    }

    void openFile() {

        JFileChooser fc = new JFileChooser();

        if (fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
            return;

        File file = fc.getSelectedFile();

        btnOpen.setEnabled(false);

        SwingWorker<ArrayList<Student>, Void> worker =
                new SwingWorker<>() {

                    @Override
                    protected ArrayList<Student> doInBackground() throws Exception {

                        ArrayList<Student> list = new ArrayList<>();

                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream(file),
                                        StandardCharsets.UTF_8));

                        br.readLine();

                        String line;

                        while ((line = br.readLine()) != null) {

                            String[] a = line.split(",");

                            if (a.length >= 3) {

                                list.add(new Student(
                                        a[0].trim(),
                                        a[1].trim(),
                                        Double.parseDouble(a[2].trim())
                                ));
                            }
                        }

                        br.close();

                        return list;
                    }

                    @Override
                    protected void done() {

                        try {

                            ArrayList<Student> list = get();

                            model.setRowCount(0);

                            double sum = 0;
                            Student max = null;

                            for (Student s : list) {

                                model.addRow(new Object[]{
                                        s.ma,
                                        s.ten,
                                        s.diem
                                });

                                sum += s.diem;

                                if (max == null || s.diem > max.diem)
                                    max = s;
                            }

                            double avg = list.isEmpty()
                                    ? 0
                                    : sum / list.size();

                            lbl.setText(String.format(
                                    "Điểm TB: %.2f | Cao nhất: %s - %.1f",
                                    avg,
                                    max == null ? "" : max.ten,
                                    max == null ? 0 : max.diem
                            ));

                        } catch (Exception e) {

                            JOptionPane.showMessageDialog(
                                    StudentCsvFrame.this,
                                    "Lỗi đọc file CSV!"
                            );
                        }

                        btnOpen.setEnabled(true);
                    }
                };

        worker.execute();
    }

    static class Student {

        String ma;
        String ten;
        double diem;

        Student(String ma, String ten, double diem) {
            this.ma = ma;
            this.ten = ten;
            this.diem = diem;
        }
    }
}