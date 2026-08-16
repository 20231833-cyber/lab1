package vn.edu.eaut.lab5.model;
public class KhachHang {
    private int maKh; private String tenKh; private String sdt; private String diaChi;
    public KhachHang() {}
    public int getMaKh() { return maKh; } public void setMaKh(int maKh) { this.maKh = maKh; }
    public String getTenKh() { return tenKh; } public void setTenKh(String tenKh) { this.tenKh = tenKh; }
    public String getSdt() { return sdt; } public void setSdt(String sdt) { this.sdt = sdt; }
    public String getDiaChi() { return diaChi; } public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    @Override public String toString() { return tenKh + " - " + sdt; }
}