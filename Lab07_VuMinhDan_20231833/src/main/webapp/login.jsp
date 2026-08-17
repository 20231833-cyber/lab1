<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><body>
    <h2>Đăng nhập Hệ thống (Filter)</h2>
    <form action="login" method="post">
        Tài khoản: <input name="username" value="admin"><br><br>
        Mật khẩu: <input type="password" name="password" value="admin"><br><br>
        <button>Login</button>
    </form>
    <p style="color:red">${error}</p>
</body></html>