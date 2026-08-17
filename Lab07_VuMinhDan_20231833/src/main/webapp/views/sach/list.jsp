<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html><body style="font-family:Arial;">
<h2>Quản lý Sách (Bài 6)</h2>
<a href="${pageContext.request.contextPath}/index.jsp">Về trang chủ</a> | <a href="sach?action=new">Thêm Sách</a><br><br>
<form method="get" action="sach">
    <input name="keyword" value="${param.keyword}" placeholder="Tìm theo tên/tác giả"> <button>Tìm</button>
</form>
<table border="1" cellpadding="6" cellspacing="0" width="80%">
    <tr style="background:#ddd"><th>ID</th><th>Mã Sách</th><th>Tên Sách</th><th>Tác giả</th><th>NXB</th><th>Năm XB</th><th>Thao tác</th></tr>
    <c:forEach var="s" items="${dsSach}">
    <tr>
        <td>${s.id}</td><td>${s.maSach}</td><td>${s.tenSach}</td><td>${s.tacGia}</td><td>${s.nxb}</td><td>${s.namXb}</td>
        <td><a href="sach?action=edit&id=${s.id}">Sửa</a> | <a href="sach?action=delete&id=${s.id}" onclick="return confirm('Xóa?')">Xóa</a></td>
    </tr>
    </c:forEach>
</table></body></html>