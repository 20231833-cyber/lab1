<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>

<head>

    <title>Danh sách sinh viên</title>

</head>

<body>

<h2>Danh sách sinh viên</h2>

<!-- BÀI 6 -->

<form action="${pageContext.request.contextPath}/students"
      method="get">

    <label>Tìm theo họ tên:</label>

    <input type="text"
           name="keyword"
           value="${keyword}"
           placeholder="Nhập họ tên">

    <button type="submit">
        Tìm kiếm
    </button>

</form>

<br>

<table border="1" cellpadding="8">

    <tr>

        <th>Mã sinh viên</th>

        <th>Họ tên</th>

        <th>Lớp</th>

        <th>Email</th>

        <th>Thao tác</th>

    </tr>

    <c:choose>

        <c:when test="${empty students}">

            <tr>

                <td colspan="5">
                    Không tìm thấy sinh viên phù hợp!
                </td>

            </tr>

        </c:when>

        <c:otherwise>

            <c:forEach var="student"
                       items="${students}">

                <tr>

                    <td>${student.id}</td>

                    <td>${student.name}</td>

                    <td>${student.className}</td>

                    <td>${student.email}</td>

                    <td>

                        <!-- BÀI 8 -->

                        <a href="${pageContext.request.contextPath}/students?action=edit&id=${student.id}">
                            Sửa
                        </a>

                        |

                        <!-- BÀI 7 -->

                        <a href="${pageContext.request.contextPath}/students?action=delete&id=${student.id}"
                           onclick="return confirm('Bạn có chắc muốn xóa sinh viên này không?')">
                            Xóa
                        </a>

                    </td>

                </tr>

            </c:forEach>

        </c:otherwise>

    </c:choose>

</table>

<br>

<a href="${pageContext.request.contextPath}/student-form.jsp">
    Thêm sinh viên
</a>

<br><br>

<a href="${pageContext.request.contextPath}/welcome.jsp">
    Trang chủ
</a>

</body>

</html>