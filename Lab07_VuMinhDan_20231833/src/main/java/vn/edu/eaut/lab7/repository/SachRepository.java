package vn.edu.eaut.lab7.repository;
import vn.edu.eaut.lab7.model.Sach;
import java.util.*;
import java.util.stream.Collectors;
public class SachRepository {
    private static final List<Sach> data = new ArrayList<>();
    private static int autoId = 3;
    static {
        data.add(new Sach(1, "S01", "Lập trình Java", "Nguyễn A", "NXB IT", 2023));
        data.add(new Sach(2, "S02", "Cấu trúc dữ liệu", "Trần B", "NXB Giáo Dục", 2022));
    }
    public List<Sach> findAll() { return data; }
    public Sach findById(int id) { return data.stream().filter(x -> x.getId() == id).findFirst().orElse(null); }
    public void add(Sach s) { s.setId(autoId++); data.add(s); }
    public void update(Sach s) {
        Sach old = findById(s.getId());
        if (old != null) { old.setMaSach(s.getMaSach()); old.setTenSach(s.getTenSach()); old.setTacGia(s.getTacGia()); old.setNxb(s.getNxb()); old.setNamXb(s.getNamXb()); }
    }
    public void delete(int id) { data.removeIf(x -> x.getId() == id); }
    public List<Sach> search(String key) {
        if (key == null || key.trim().isEmpty()) return data;
        String k = key.toLowerCase();
        return data.stream().filter(x -> x.getTenSach().toLowerCase().contains(k) || x.getTacGia().toLowerCase().contains(k)).collect(Collectors.toList());
    }
}