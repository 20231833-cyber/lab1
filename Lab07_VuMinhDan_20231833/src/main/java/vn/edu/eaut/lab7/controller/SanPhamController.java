package vn.edu.eaut.lab7.controller;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.edu.eaut.lab7.model.SanPham;
import vn.edu.eaut.lab7.repository.SanPhamRepository;
import java.io.IOException;
@WebServlet("/admin/san-pham")
public class SanPhamController extends HttpServlet {
    private final SanPhamRepository repo = new SanPhamRepository();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("new".equals(action)) { req.getRequestDispatcher("/views/sanpham/form.jsp").forward(req, resp); return; }
        if ("edit".equals(action)) { req.setAttribute("sp", repo.findById(Integer.parseInt(req.getParameter("id")))); req.getRequestDispatcher("/views/sanpham/form.jsp").forward(req, resp); return; }
        if ("delete".equals(action)) { repo.delete(Integer.parseInt(req.getParameter("id"))); resp.sendRedirect(req.getContextPath() + "/admin/san-pham"); return; }
        req.setAttribute("dsSp", repo.search(req.getParameter("keyword")));
        req.getRequestDispatcher("/views/sanpham/list.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        double gia = Double.parseDouble(req.getParameter("gia"));
        int sl = Integer.parseInt(req.getParameter("soLuong"));
        
        // Bài 7: Validate giá > 0 và số lượng >= 0
        if(gia <= 0 || sl < 0) {
            req.setAttribute("error", "Giá phải > 0 và Số lượng >= 0");
            req.setAttribute("sp", new SanPham(id == null || id.isBlank() ? 0 : Integer.parseInt(id), req.getParameter("maSp"), req.getParameter("tenSp"), req.getParameter("moTa"), gia, sl));
            req.getRequestDispatcher("/views/sanpham/form.jsp").forward(req, resp);
            return;
        }
        
        SanPham sp = new SanPham(id == null || id.isBlank() ? 0 : Integer.parseInt(id), req.getParameter("maSp"), req.getParameter("tenSp"), req.getParameter("moTa"), gia, sl);
        if (sp.getId() == 0) repo.add(sp); else repo.update(sp);
        resp.sendRedirect(req.getContextPath() + "/admin/san-pham");
    }
}