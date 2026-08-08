package vn.edu.eaut.lab3;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Bai08QuanLySinhVien extends JFrame {
    private JTextField txtId = new JTextField();
    private JTextField txtName = new JTextField();
    private JTextField txtScore = new JTextField();
    private DefaultTableModel model;
    private JTable table;

    public Bai08QuanLySinhVien() {
        setTitle("Bài 8 - Quản lý sinh viên");
        setLayout(new BorderLayout());
        
        JPanel pnlInput = new JPanel(new GridLayout(3, 2, 5, 5));
        pnlInput.add(new JLabel(" Mã Sinh Viên:")); pnlInput.add(txtId);
        pnlInput.add(new JLabel(" Họ và Tên:")); pnlInput.add(txtName);
        pnlInput.add(new JLabel(" Điểm Trung Bình:")); pnlInput.add(txtScore);
        
        JPanel pnlButtons = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Thêm"); JButton btnEdit = new JButton("Sửa");
        JButton btnDel = new JButton("Xóa"); JButton btnClear = new JButton("Làm mới");
        pnlButtons.add(btnAdd); pnlButtons.add(btnEdit); 
        pnlButtons.add(btnDel); pnlButtons.add(btnClear);
        
        JPanel pnlTop = new JPanel(new BorderLayout());
        pnlTop.add(pnlInput, BorderLayout.CENTER);
        pnlTop.add(pnlButtons, BorderLayout.SOUTH);
        
        String[] cols = {"Mã SV", "Họ Tên", "Điểm TB", "Xếp Loại"};
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        
        add(pnlTop, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        
        btnAdd.addActionListener(e -> addStudent());
        btnDel.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row >= 0) model.removeRow(row);
            else JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần xóa!");
        });
        btnClear.addActionListener(e -> { txtId.setText(""); txtName.setText(""); txtScore.setText(""); });
        
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void addStudent() {
        try {
            String id = txtId.getText().trim(); 
            String name = txtName.getText().trim();
            if (id.isEmpty() || name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!");
                return;
            }
            double score = Double.parseDouble(txtScore.getText().trim());
            if (score < 0 || score > 10) {
                JOptionPane.showMessageDialog(this, "Điểm phải từ 0 đến 10!");
                return;
            }
            String rank = (score >= 8.5) ? "Giỏi" : (score >= 7) ? "Khá" : (score >= 5) ? "Trung bình" : "Yếu";
            model.addRow(new Object[]{id, name, score, rank});
            
            txtId.setText(""); txtName.setText(""); txtScore.setText("");
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Điểm phải là một số hợp lệ!");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai08QuanLySinhVien().setVisible(true));
    }
}