<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html><body style="font-family:Arial;">
<h2>Danh sách sinh viên</h2>
<a href="${pageContext.request.contextPath}/index.jsp">Về trang chủ</a> | <a href="sinh-vien?action=new">Thêm sinh viên</a><br><br>
<form method="get" action="sinh-vien">
    <input name="keyword" value="${param.keyword}" placeholder="Tìm theo tên hoặc lớp"> <button>Tìm</button>
</form>
<table border="1" cellpadding="6" cellspacing="0" width="80%">
    <tr style="background:#ddd"><th>ID</th><th>Mã SV</th><th>Họ tên</th><th>Email</th><th>Lớp</th><th>Thao tác</th></tr>
    <c:forEach var="sv" items="${dsSinhVien}">
    <tr>
        <td>${sv.id}</td><td>${sv.maSinhVien}</td>
        <td><a href="sinh-vien?action=detail&id=${sv.id}">${sv.hoTen}</a></td>
        <td>${sv.email}</td><td>${sv.lop}</td>
        <td><a href="sinh-vien?action=edit&id=${sv.id}">Sửa</a> | <a href="sinh-vien?action=delete&id=${sv.id}" onclick="return confirm('Xóa?')">Xóa</a></td>
    </tr>
    </c:forEach>
</table></body></html>