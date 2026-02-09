<%-- Document : register Created on : Feb 10, 2026, 1:57:03 AM Author : nguye
--%> <%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <title>Register</title>
  </head>
  <body>
    <h2>Tạo tài khoản nhân viên</h2>
    <form action="LoginServlet" method="post">
      <label>Username:</label><br />
      <input type="text" name="username" required /><br /><br />

      <label>Password:</label><br />
      <input type="password" name="password" required /><br /><br />

      <label>Họ tên:</label><br />
      <input type="text" name="name" required /><br /><br />

      <label>Vai trò:</label><br />
      <select name="role">
        <option value="STAFF">Nhân viên</option>
        <option value="ADMIN">Quản lý</option></select
      ><br /><br />
      <input type="hidden" name="command" value="register" />
      <button type="submit">Đăng ký</button>
    </form>
    <br />
    <a href="login.jsp">Quay lại đăng nhập</a>
  </body>
</html>
