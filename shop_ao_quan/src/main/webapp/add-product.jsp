<%-- 
    Document   : add-product
    Created on : Feb 16, 2026, 2:21:41 AM
    Author     : nguye
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Sản Phẩm</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<header>
    <h1>Thêm Sản Phẩm Mới</h1>
</header>

<main class="form-container">

    <form action="AdminCommand" method="post" enctype="multipart/form-data">

        <h2>Thông Tin Sản Phẩm</h2>

        <label>Tên sản phẩm</label>
        <input type="text" name="name" required>
        <input type="hidden" name="command" value="add">
        <label>Danh mục</label>
        <select name="category">
            <option value="Nam">Thời Trang Nam</option>
            <option value="Nu">Thời Trang Nữ</option>
            <option value="Combo">Combo Theo Mùa</option>
        </select>

        <div class="form-group">
                    <label>Poster</label>
                    <input
                        type="file"
                        name="poster"
                        class="form-control"
                        accept="image/*"
                        required
                        />
                </div>

        <hr>

        <h2>Biến Thể Sản Phẩm</h2>

        <div id="variants">

            <div class="variant">
                <label>Size</label>
                <input type="text" name="size">

                <label>Màu</label>
                <input type="text" name="color">

                <label>Giá</label>
                <input type="number" name="price">

                <label>Số lượng</label>
                <input type="number" name="stock">
            </div>

        </div>

        <button type="button" onclick="addVariant()">+ Thêm biến thể</button>

        <br><br>
        <button type="submit">Lưu Sản Phẩm</button>

    </form>

</main>

<script>
function addVariant() {
    const container = document.getElementById("variants");

    const html = `
        <div class="variant">
            <label>Size</label>
            <input type="text" name="size">

            <label>Màu</label>
            <input type="text" name="color">

            <label>Giá</label>
            <input type="number" name="price">

            <label>Số lượng</label>
            <input type="number" name="stock">
        </div>
        <hr>
    `;

    container.insertAdjacentHTML("beforeend", html);
}
</script>

</body>
</html>
