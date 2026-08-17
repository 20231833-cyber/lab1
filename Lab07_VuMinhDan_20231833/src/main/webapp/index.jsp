<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><title>Lab 7 - CRUD MVC</title><style>body{font-family:Arial; padding: 20px;} a{text-decoration:none; color:blue;}</style></head>
<body>
    <h2>Lab 7 - CRUD bằng Servlet + JSP, dùng MVC đơn giản</h2>
    <p>Xin chào, <b>${sessionScope.username != null ? sessionScope.username : 'Khách'}</b>!</p>
    <ul>
        <li><a href="${pageContext.request.contextPath}/admin/sinh-vien">Quản lý Sinh viên</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/sach">Quản lý Sách (Bài 6)</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/san-pham">Quản lý Sản phẩm (Bài 7)</a></li>
        <hr>
        <li><a href="${pageContext.request.contextPath}/login.jsp">Đăng nhập (Admin)</a></li>
        <li><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
    </ul>
</body></html>