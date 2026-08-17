package vn.edu.eaut.lab7.repository;
import vn.edu.eaut.lab7.model.SanPham;
import java.util.*;
import java.util.stream.Collectors;
public class SanPhamRepository {
    private static final List<SanPham> data = new ArrayList<>();
    private static int autoId = 3;
    static {
        data.add(new SanPham(1, "SP01", "Laptop Dell", "Laptop Gaming", 15000000, 10));
        data.add(new SanPham(2, "SP02", "Chuột Logitech", "Chuột ko dây", 500000, 50));
    }
    public List<SanPham> findAll() { return data; }
    public SanPham findById(int id) { return data.stream().filter(x -> x.getId() == id).findFirst().orElse(null); }
    public void add(SanPham sp) { sp.setId(autoId++); data.add(sp); }
    public void update(SanPham sp) {
        SanPham old = findById(sp.getId());
        if (old != null) { old.setMaSp(sp.getMaSp()); old.setTenSp(sp.getTenSp()); old.setMoTa(sp.getMoTa()); old.setGia(sp.getGia()); old.setSoLuong(sp.getSoLuong()); }
    }
    public void delete(int id) { data.removeIf(x -> x.getId() == id); }
    public List<SanPham> search(String key) {
        if (key == null || key.trim().isEmpty()) return data;
        String k = key.toLowerCase();
        return data.stream().filter(x -> x.getTenSp().toLowerCase().contains(k)).collect(Collectors.toList());
    }
}