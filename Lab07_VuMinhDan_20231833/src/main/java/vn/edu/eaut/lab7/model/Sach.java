package vn.edu.eaut.lab7.model;
public class Sach {
    private int id;
    private String maSach, tenSach, tacGia, nxb;
    private int namXb;
    public Sach() {}
    public Sach(int id, String maSach, String tenSach, String tacGia, String nxb, int namXb) {
        this.id = id; this.maSach = maSach; this.tenSach = tenSach; this.tacGia = tacGia; this.nxb = nxb; this.namXb = namXb;
    }
    public int getId() { return id; } public void setId(int id) { this.id = id; }
    public String getMaSach() { return maSach; } public void setMaSach(String maSach) { this.maSach = maSach; }
    public String getTenSach() { return tenSach; } public void setTenSach(String tenSach) { this.tenSach = tenSach; }
    public String getTacGia() { return tacGia; } public void setTacGia(String tacGia) { this.tacGia = tacGia; }
    public String getNxb() { return nxb; } public void setNxb(String nxb) { this.nxb = nxb; }
    public int getNamXb() { return namXb; } public void setNamXb(int namXb) { this.namXb = namXb; }
}