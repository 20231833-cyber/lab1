<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>

<head>

    <title>Dashboard</title>

</head>

<body>

<h2>Dashboard</h2>

<p>
    Xin chào:
    <strong>${username}</strong>
</p>

<p>
    Thời gian đăng nhập:
    <strong>${loginTime}</strong>
</p>

<hr>

<h3>Tổng số sinh viên</h3>

<h1>${totalStudents}</h1>

<h3>Số sinh viên theo từng lớp</h3>

<table border="1" cellpadding="8">

    <tr>

        <th>Lớp</th>

        <th>Số sinh viên</th>

    </tr>

    <c:forEach var="item"
               items="${classCount}">

        <tr>

            <td>${item.key}</td>

            <td>${item.value}</td>

        </tr>

    </c:forEach>

</table>

<br>

<a href="${pageContext.request.contextPath}/students">
    Quản lý sinh viên
</a>

<br><br>

<a href="${pageContext.request.contextPath}/welcome.jsp">
    Trang chủ
</a>

</body>

</html>