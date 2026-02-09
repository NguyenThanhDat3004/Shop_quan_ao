<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
  <head>
    <title>Register</title>

    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/register.css"
    />
  </head>
  <body>
    <div class="register-box">
      <h2>Tạo tài khoản nhân viên</h2>

      <form action="LoginServlet" method="post">
        <label>Username</label>
        <input type="text" name="username" required />

        <label>Password</label>
        <input type="password" name="password" required />

        <label>Họ tên</label>
        <input type="text" name="name" required />
        <label>Vai trò</label>
        <select name="role">
          <option value="STAFF">Nhân viên</option>
          <option value="ADMIN">Quản lý</option>
          <option value="CUSTOMER">Khách hàng</option>
        </select>

        <input type="hidden" name="command" value="register" />

        <button type="submit">Đăng ký</button>
      </form>

      <a href="${pageContext.request.contextPath}/login.jsp">
        Quay lại đăng nhập
      </a>
    </div>
  </body>
</html>
