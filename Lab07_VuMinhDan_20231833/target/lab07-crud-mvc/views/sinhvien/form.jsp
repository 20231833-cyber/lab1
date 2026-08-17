<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><body style="font-family:Arial;">
<h2>Form sinh viên</h2>
<form method="post" action="sinh-vien">
    <input type="hidden" name="id" value="${sv.id}">
    <p>Mã SV: <input name="maSinhVien" value="${sv.maSinhVien}" required></p>
    <p>Họ tên: <input name="hoTen" value="${sv.hoTen}" required></p>
    <p>Email: <input name="email" value="${sv.email}" type="email"></p>
    <p>Lớp: <input name="lop" value="${sv.lop}"></p>
    <button type="submit">Lưu</button> <a href="sinh-vien">Hủy</a>
</form></body></html>