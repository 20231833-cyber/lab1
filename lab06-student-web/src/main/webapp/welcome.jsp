<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Trang chủ</title>

</head>

<body>

<h2>Chào mừng đến hệ thống quản lý sinh viên</h2>

<p>
    Xin chào:
    <strong>${sessionScope.username}</strong>
</p>

<p>
    Quyền:
    <strong>${sessionScope.role}</strong>
</p>

<hr>

<a href="${pageContext.request.contextPath}/students">
    Xem danh sách sinh viên
</a>

<br><br>

<a href="${pageContext.request.contextPath}/dashboard">
    Dashboard
</a>

<br><br>

<a href="${pageContext.request.contextPath}/student-form.jsp">
    Thêm sinh viên
</a>

<br><br>

<a href="${pageContext.request.contextPath}/logout">
    Đăng xuất
</a>

</body>

</html>