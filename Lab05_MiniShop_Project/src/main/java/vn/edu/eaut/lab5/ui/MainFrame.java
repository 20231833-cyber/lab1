package vn.edu.eaut.lab5.ui;
import javax.swing.*;
public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Quản lý bán hàng MiniShop");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Sản phẩm", new SanPhamPanel());
        tabbedPane.addTab("Khách hàng", new KhachHangPanel());
        tabbedPane.addTab("Hóa đơn", new HoaDonPanel());
        tabbedPane.addTab("Thống kê", new ThongKePanel());
        add(tabbedPane);
    }
}