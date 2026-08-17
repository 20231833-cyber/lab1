package vn.edu.eaut.lab7.model;
public class SanPham {
    private int id;
    private String maSp, tenSp, moTa;
    private double gia;
    private int soLuong;
    public SanPham() {}
    public SanPham(int id, String maSp, String tenSp, String moTa, double gia, int soLuong) {
        this.id = id; this.maSp = maSp; this.tenSp = tenSp; this.moTa = moTa; this.gia = gia; this.soLuong = soLuong;
    }
    public int getId() { return id; } public void setId(int id) { this.id = id; }
    public String getMaSp() { return maSp; } public void setMaSp(String maSp) { this.maSp = maSp; }
    public String getTenSp() { return tenSp; } public void setTenSp(String tenSp) { this.tenSp = tenSp; }
    public String getMoTa() { return moTa; } public void setMoTa(String moTa) { this.moTa = moTa; }
    public double getGia() { return gia; } public void setGia(double gia) { this.gia = gia; }
    public int getSoLuong() { return soLuong; } public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
}