package vn.edu.eaut.lab8.bean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import vn.edu.eaut.lab8.model.SinhVien;
import vn.edu.eaut.lab8.repository.SinhVienRepository;
import java.io.Serializable;
import java.util.List;

@Named("sinhVienBean")
@SessionScoped
public class SinhVienBean implements Serializable {
    private SinhVien sinhVien = new SinhVien();
    private final SinhVienRepository repo = new SinhVienRepository();
    private String keyword; // For searching (Bài 10)

    public String save() {
        if (sinhVien.getId() == 0) {
            repo.add(sinhVien);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Thành công", "Đã lưu sinh viên"));
        } else {
            repo.update(sinhVien); // Bài 9
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Thành công", "Đã cập nhật sinh viên"));
        }
        sinhVien = new SinhVien();
        return "sinhvien-list?faces-redirect=true";
    }

    public void delete(int id) {
        repo.delete(id);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Thành công", "Đã xóa sinh viên"));
    }

    public String edit(SinhVien sv) {
        this.sinhVien = new SinhVien(sv.getId(), sv.getMaSinhVien(), sv.getHoTen(), sv.getEmail(), sv.getLop());
        return "sinhvien-form?faces-redirect=true";
    }

    public void search() {
        // Just a dummy action to trigger re-render
    }

    public void clearSearch() { keyword = null; }

    public List<SinhVien> getDsSinhVien() {
        return repo.search(keyword);
    }

    public SinhVien getSinhVien() { return sinhVien; }
    public void setSinhVien(SinhVien sinhVien) { this.sinhVien = sinhVien; }
    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }
}