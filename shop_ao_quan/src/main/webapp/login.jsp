<%-- Document : login Created on : Feb 10, 2026, 1:00:03 AM Author : nguye --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>

<div class="login-box">

    <!-- message -->
    <%
        if (request.getAttribute("error") != null
            || request.getAttribute("success") != null) {
    %>
        <jsp:include page="component/message.jsp" />
    <%
        }
    %>

    <h2>Login</h2>

    <form action="LoginServlet" method="post">
        <label>Username</label>
        <input type="text" name="username" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <button type="submit">Login</button>
    </form>

    <p style="text-align:center; margin-top:16px;">
        Chưa có tài khoản?
        <a href="${pageContext.request.contextPath}/register.jsp">
            Tạo tài khoản
        </a>
    </p>

</div>

</body>
</html>
