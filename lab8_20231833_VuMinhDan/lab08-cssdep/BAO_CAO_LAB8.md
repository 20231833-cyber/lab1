# LAB 8 - BÁO CÁO NGẮN

**Sinh viên:** Vũ Minh Dân  
**MSSV:** 20231833  
**Học phần:** Công nghệ Java - IT3242

## Bài 1. Tạo trang JSF đầu tiên
- File: `index.xhtml`
- Sử dụng `h:head`, `h:body`, `h:link`.
- FacesServlet được cấu hình trong `WEB-INF/web.xml` với URL `*.xhtml`.

## Bài 2. Model và Repository
- `SinhVien.java`: model sinh viên.
- `SinhVienRepository.java`: lưu dữ liệu bằng `List`, không dùng MySQL/JPA.
- Có 2 sinh viên mẫu và chức năng thêm/xóa/cập nhật/tìm kiếm.

## Bài 3. Managed Bean/CDI Bean
- `SinhVienBean.java` dùng `@Named("sinhVienBean")` và `@SessionScoped`.
- Bean nhận dữ liệu từ XHTML thông qua Expression Language `#{...}`.
- Bean gọi Repository và tạo `FacesMessage`.

## Bài 4. Form JSF, validation và message
- `sinhvien-form.xhtml` sử dụng `h:form`, `h:inputText`, `h:selectOneMenu`, `h:commandButton`.
- Có `required`, Bean Validation trong model, `h:message` và `h:messages`.
- Khi lưu đúng hiển thị thông báo thành công.

## Bài 5. DataTable và xóa dữ liệu
- `sinhvien-list.xhtml` dùng `h:dataTable`.
- Nút Xóa gọi trực tiếp `sinhVienBean.delete(sv.id)`.

## Bài 6-12
- Bài 6: form Sách + validation.
- Bài 7: form Sản phẩm + validation.
- Bài 8: đăng nhập JSF, sai tài khoản có FacesMessage.
- Bài 9: sửa sinh viên.
- Bài 10: tìm kiếm theo họ tên/lớp.
- Bài 11: template + header + menu + footer.
- Bài 12: `h:selectOneMenu` cho trường lớp.

## Bài 13. So sánh Servlet/JSP và JSF
| Nội dung | Servlet/JSP | JSF |
|---|---|---|
| Giao diện | JSP + HTML/JSTL | XHTML + JSF component |
| Xử lý form | Servlet | Managed Bean/CDI Bean |
| Nhận dữ liệu | `request.getParameter()` | `#{bean.property}` |
| Validation | Thường tự kiểm tra | `required` + Bean Validation |
| Message | Tự truyền sang JSP | `FacesMessage` + `h:message` |
| Bảng | JSTL | `h:dataTable` |
| Điều hướng | forward/sendRedirect | outcome/faces-redirect |

## Kết luận
Lab 8 chuyển một form từ cách xử lý Servlet/JSP sang Jakarta Faces/JSF, giúp làm quen component-based UI, validation, message, Managed Bean/CDI và `h:dataTable`.
