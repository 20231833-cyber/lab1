<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><body style="font-family:Arial;">
<h2>Form Sản Phẩm</h2>
<p style="color:red">${error}</p>
<form method="post" action="san-pham">
    <input type="hidden" name="id" value="${sp.id}">
    <p>Mã SP: <input name="maSp" value="${sp.maSp}" required></p>
    <p>Tên SP: <input name="tenSp" value="${sp.tenSp}" required></p>
    <p>Mô tả: <input name="moTa" value="${sp.moTa}"></p>
    <p>Giá: <input type="number" step="0.1" name="gia" value="${sp.gia}" required></p>
    <p>Số lượng: <input type="number" name="soLuong" value="${sp.soLuong}" required></p>
    <button type="submit">Lưu</button> <a href="san-pham">Hủy</a>
</form></body></html>