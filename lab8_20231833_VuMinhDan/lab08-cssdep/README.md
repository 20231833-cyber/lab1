# lab08-jsf-validation

Lab 8 - Công nghệ Java (IT3242)

Sinh viên: Vũ Minh Dân - 20231833

## Công nghệ
- JDK 17
- Maven
- Jakarta Faces 4.0.7
- Weld 5.1.2.Final
- Hibernate Validator 8.0.1.Final
- Tomcat 10.1.x

## Các bài
Bài 1-5 dùng đúng các thành phần code gợi ý trong PDF Lab 8: index.xhtml, SinhVien, SinhVienRepository, SinhVienBean, sinhvien-form.xhtml, sinhvien-list.xhtml.
Bài 6-13 được bổ sung theo yêu cầu phần bài tập không có code gợi ý.

## Chạy
1. Mở thư mục `lab08-jsf-validation` bằng IntelliJ IDEA.
2. Reload Maven.
3. Chọn JDK 17.
4. Tạo Tomcat 10.1.x.
5. Deployment: `lab8:war exploded`.
6. Application context: `/lab8` hoặc `/` nếu muốn chạy tại root.
7. Nếu context là `/lab8`: `http://localhost:8080/lab8/`
8. Nếu context là `/`: `http://localhost:8080/`

`web.xml` đã có welcome-file `index.xhtml`.

## Tài khoản Bài 8
Username: admin
Password: 123456

## Database
Lab 8 lưu sinh viên bằng List trong bộ nhớ, chưa dùng MySQL/JPA theo phạm vi của PDF.
