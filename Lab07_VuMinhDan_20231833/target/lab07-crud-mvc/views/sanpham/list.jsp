<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html><body style="font-family:Arial;">
<h2>Quản lý Sản phẩm (Bài 7)</h2>
<a href="${pageContext.request.contextPath}/index.jsp">Về trang chủ</a> | <a href="san-pham?action=new">Thêm SP</a><br><br>
<form method="get" action="san-pham">
    <input name="keyword" value="${param.keyword}" placeholder="Tìm theo tên"> <button>Tìm</button>
</form>
<table border="1" cellpadding="6" cellspacing="0" width="80%">
    <tr style="background:#ddd"><th>Mã SP</th><th>Tên SP</th><th>Mô tả</th><th>Giá</th><th>Số lượng</th><th>Thao tác</th></tr>
    <c:forEach var="s" items="${dsSp}">
    <tr>
        <td>${s.maSp}</td><td>${s.tenSp}</td><td>${s.moTa}</td><td>${s.gia}</td><td>${s.soLuong}</td>
        <td><a href="san-pham?action=edit&id=${s.id}">Sửa</a> | <a href="san-pham?action=delete&id=${s.id}" onclick="return confirm('Xóa?')">Xóa</a></td>
    </tr>
    </c:forEach>
</table></body></html>