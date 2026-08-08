package vn.edu.eaut.lab3;
import javax.swing.*;
import java.awt.*;

public class Bai06LoginForm extends JFrame {
    private JTextField txtUser = new JTextField();
    private JPasswordField txtPass = new JPasswordField();
    private JComboBox<String> cbRole = new JComboBox<>(new String[]{"Admin", "User"});
    private JCheckBox chkShowPass = new JCheckBox("Hiển thị mật khẩu");

    public Bai06LoginForm() {
        setTitle("Bài 6 - Đăng nhập");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));
        
        add(new JLabel(" Tài khoản:")); add(txtUser);
        add(new JLabel(" Mật khẩu:")); add(txtPass);
        add(new JLabel(" Vai trò:")); add(cbRole);
        add(new JLabel("")); add(chkShowPass);
        
        JButton btnLogin = new JButton("Đăng nhập");
        add(btnLogin);
        
        chkShowPass.addActionListener(e -> {
            if (chkShowPass.isSelected()) txtPass.setEchoChar((char) 0);
            else txtPass.setEchoChar('•');
        });
        
        btnLogin.addActionListener(e -> login());
        setLocationRelativeTo(null);
    }
    
    private void login() {
        String u = txtUser.getText();
        String p = new String(txtPass.getPassword());
        String r = (String) cbRole.getSelectedItem();
        
        if ("admin".equals(u) && "123456".equals(p) && "Admin".equals(r)) {
            JOptionPane.showMessageDialog(this, "Chào mừng Admin!");
        } else if ("user".equals(u) && "123456".equals(p) && "User".equals(r)) {
            JOptionPane.showMessageDialog(this, "Chào mừng User!");
        } else {
            JOptionPane.showMessageDialog(this, "Sai thông tin đăng nhập! Vui lòng thử lại.");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai06LoginForm().setVisible(true));
    }
}