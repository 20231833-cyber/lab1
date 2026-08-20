package vn.edu.eaut.lab8.repository;

import vn.edu.eaut.lab8.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachRepository {
    private static final List<Sach> data = new ArrayList<>();
    private static int autoId = 3;

    static {
        data.add(new Sach(1, "Java cơ bản", "Nguyễn Văn An", 2023));
        data.add(new Sach(2, "Lập trình JSF", "Trần Thị Bình", 2024));
    }

    public List<Sach> findAll() { return data; }

    public void add(Sach sach) {
        sach.setId(autoId++);
        data.add(sach);
    }

    public void delete(int id) {
        data.removeIf(sach -> sach.getId() == id);
    }
}
