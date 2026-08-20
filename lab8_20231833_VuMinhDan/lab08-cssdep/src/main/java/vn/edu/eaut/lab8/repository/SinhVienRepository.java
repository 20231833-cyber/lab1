package vn.edu.eaut.lab8.repository;
import vn.edu.eaut.lab8.model.SinhVien;
import java.util.*;
import java.util.stream.Collectors;

public class SinhVienRepository {
    private static final List<SinhVien> data = new ArrayList<>();
    private static int autoId = 3;
    static {
        data.add(new SinhVien(1, "20240001", "Nguyễn Văn An", "an@gmail.com", "DCCNTT15.10.1"));
        data.add(new SinhVien(2, "20240002", "Trần Thị Bình", "binh@gmail.com", "DCCNTT15.10.2"));
    }
    public List<SinhVien> findAll() { return data; }
    public void add(SinhVien sv) { sv.setId(autoId++); data.add(sv); }
    public void delete(int id) { data.removeIf(x -> x.getId() == id); }
    
    // Bài 9: Cập nhật
    public void update(SinhVien sv) {
        for (SinhVien s : data) {
            if (s.getId() == sv.getId()) {
                s.setMaSinhVien(sv.getMaSinhVien());
                s.setHoTen(sv.getHoTen());
                s.setEmail(sv.getEmail());
                s.setLop(sv.getLop());
                break;
            }
        }
    }
    
    // Bài 10: Tìm kiếm
    public List<SinhVien> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) return data;
        String kw = keyword.toLowerCase();
        return data.stream()
                .filter(s -> s.getHoTen().toLowerCase().contains(kw) || s.getLop().toLowerCase().contains(kw))
                .collect(Collectors.toList());
    }
}