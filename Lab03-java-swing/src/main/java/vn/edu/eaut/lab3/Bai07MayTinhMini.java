package vn.edu.eaut.lab3;
import javax.swing.*;
import java.awt.*;

public class Bai07MayTinhMini extends JFrame {
    private JTextField txtA = new JTextField();
    private JTextField txtB = new JTextField();
    private JLabel lblResult = new JLabel("Kết quả: ");
    private JTextArea txtHistory = new JTextArea(5, 20);

    public Bai07MayTinhMini() {
        setTitle("Bài 7 - Máy tính mini");
        setLayout(new BorderLayout(5, 5));
        
        JPanel pnlInput = new JPanel(new GridLayout(2, 2, 5, 5));
        pnlInput.add(new JLabel(" Số thứ nhất (A):")); pnlInput.add(txtA);
        pnlInput.add(new JLabel(" Số thứ hai (B):")); pnlInput.add(txtB);
        
        JPanel pnlButtons = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("+"); JButton btnSub = new JButton("-");
        JButton btnMul = new JButton("*"); JButton btnDiv = new JButton("/");
        JButton btnClear = new JButton("Clear");
        
        pnlButtons.add(btnAdd); pnlButtons.add(btnSub);
        pnlButtons.add(btnMul); pnlButtons.add(btnDiv); pnlButtons.add(btnClear);
        
        btnAdd.addActionListener(e -> calc("+"));
        btnSub.addActionListener(e -> calc("-"));
        btnMul.addActionListener(e -> calc("*"));
        btnDiv.addActionListener(e -> calc("/"));
        btnClear.addActionListener(e -> { txtA.setText(""); txtB.setText(""); lblResult.setText("Kết quả: "); });
        
        JPanel pnlTop = new JPanel(new BorderLayout());
        pnlTop.add(pnlInput, BorderLayout.CENTER);
        pnlTop.add(pnlButtons, BorderLayout.SOUTH);
        
        add(pnlTop, BorderLayout.NORTH);
        txtHistory.setEditable(false);
        add(new JScrollPane(txtHistory), BorderLayout.CENTER);
        add(lblResult, BorderLayout.SOUTH);
        
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void calc(String op) {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double res = 0;
            if (op.equals("+")) res = a + b;
            if (op.equals("-")) res = a - b;
            if (op.equals("*")) res = a * b;
            if (op.equals("/")) {
                if (b == 0) { JOptionPane.showMessageDialog(this, "Lỗi: Không thể chia cho 0!"); return; }
                res = a / b;
            }
            lblResult.setText("Kết quả: " + res);
            txtHistory.append(String.format("%.2f %s %.2f = %.2f\n", a, op, b, res));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai07MayTinhMini().setVisible(true));
    }
}