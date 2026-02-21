<%-- 
    Document   : home-page
    Created on : Feb 12, 2026, 6:48:20 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Fashion Shop Dashboard</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/home-page.css">
</head>
<body>

    <!-- HEADER -->
    <header>
        <h1>FASHION SHOP</h1>
        <nav>
            <a href="#">Trang chủ</a> |
            <a href="#">Giỏ hàng</a> |
            <a href="#">Đăng xuất</a>|
            <form action="AdminCommand" method="get">
          <label for="admin-options">Admin Options:</label>
          <select
            name="command"
            id="admin-options"
            onchange="this.form.submit()"
          >
            <option value="" disabled selected>Chọn hành động</option>
            <option value="delete">Xóa</option>
            <option value="update">Cập nhật</option>
            <option value="create">Tạo mới Product</option>
            <option value="create">Tạo mới Product Variant</option>
          </select>
        </form>
        </nav>
        <hr>
    </header>

    <!-- MAIN MENU -->
    <main>
        <h2>Danh Mục Sản Phẩm</h2>

        <ul>
            <section class="category">
                <h3>👔 Thời Trang Nam</h3>

                <div class="slider">
                    <button class="nav" onclick="slide('men', -1)">❮</button>

                    <div class="viewport">
                        <div class="product-container" id="men">

                            <c:forEach var="p" items="${menProducts}">
                                <div class="product">
                                    <img src="${p.imageUrl}" alt="">
                                    <p>${p.name}</p>
                                    <span>${p.price}đ</span>
                                </div>
                            </c:forEach>

                        </div>
                    </div>

                    <button class="nav" onclick="slide('men', 1)">❯</button>
                </div>
            </section>



            <section class="category">
                <h3>👗 Thời Trang Nữ</h3>

                <div class="slider">
                    <button class="nav" onclick="slide('women', -1)">❮</button>

                    <div class="viewport">
                        <div class="product-container" id="women">

                            <c:forEach var="p" items="${womenProducts}">
                                <div class="product">
                                    <img src="${p.imageUrl}">
                                    <p>${p.name}</p>
                                    <span>${p.price}đ</span>
                                </div>
                            </c:forEach>

                        </div>
                    </div>

                    <button class="nav" onclick="slide('women', 1)">❯</button>
                </div>
            </section>
        </ul>
    </main>

    <hr>

    <!-- SHOP INFO -->
    <footer>
        <h3>Thông Tin Shop</h3>
        <p>Địa chỉ: Đà Nẵng, Việt Nam</p>
        <p>Hotline: 0123 456 789</p>
        <p>Email: fashionshop@email.com</p>
        <p>&copy; 2026 Fashion Shop</p>
    </footer>
    <script>
        const positions = {};

        function slide(id, direction) {
            const container = document.getElementById(id);
            const itemWidth = 220; // width + margin
            const visibleItems = 5;

            if (!positions[id]) positions[id] = 0;

            const maxPosition =
                container.children.length - visibleItems;

            positions[id] += direction;

            if (positions[id] < 0) positions[id] = 0;
            if (positions[id] > maxPosition) positions[id] = maxPosition;

            container.style.transform =
                `translateX(-${positions[id] * itemWidth}px)`;
        }
        </script>

</body>
</html>
