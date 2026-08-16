<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>

<head>
    <title>
        ${empty student ? "Thêm sinh viên" : "Cập nhật sinh viên"}
    </title>
</head>

<body>

<h2>
    ${empty student ? "Thêm sinh viên" : "Cập nhật thông tin sinh viên"}
</h2>

<form action="${pageContext.request.contextPath}/students"
      method="post">

    <input type="hidden"
           name="action"
           value="${empty student ? 'add' : 'update'}">

    <label>Mã sinh viên:</label>
    <br>

    <input type="text"
           name="id"
           value="${student.id}"
           <c:if test="${not empty student}">readonly</c:if>
           required>

    <br><br>

    <label>Họ tên:</label>
    <br>

    <input type="text"
           name="name"
           value="${student.name}"
           required>

    <br><br>

    <label>Lớp:</label>
    <br>

    <input type="text"
           name="className"
           value="${student.className}"
           required>

    <br><br>

    <label>Email:</label>
    <br>

    <input type="email"
           name="email"
           value="${student.email}"
           required>

    <br><br>

    <button type="submit">
        ${empty student ? "Lưu sinh viên" : "Cập nhật"}
    </button>

</form>

<br>

<a href="${pageContext.request.contextPath}/students">
    Quay lại danh sách
</a>

</body>

</html>