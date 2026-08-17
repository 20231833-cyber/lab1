<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><body style="font-family:Arial;">
<h2>Form Sách</h2>
<form method="post" action="sach">
    <input type="hidden" name="id" value="${sach.id}">
    <p>Mã Sách: <input name="maSach" value="${sach.maSach}" required></p>
    <p>Tên Sách: <input name="tenSach" value="${sach.tenSach}" required></p>
    <p>Tác Giả: <input name="tacGia" value="${sach.tacGia}" required></p>
    <p>NXB: <input name="nxb" value="${sach.nxb}"></p>
    <p>Năm XB: <input type="number" name="namXb" value="${sach.namXb}"></p>
    <button type="submit">Lưu</button> <a href="sach">Hủy</a>
</form></body></html>