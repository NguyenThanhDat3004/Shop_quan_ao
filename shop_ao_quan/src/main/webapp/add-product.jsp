<%-- Document : add-product Created on : Feb 16, 2026, 2:21:41 AM Author : nguye
--%> <%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
  <head>
    <meta charset="UTF-8" />
    <title>Thêm Sản Phẩm</title>
    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>

    <form action="AdminCommand" method="post" enctype="multipart/form-data">
      <h2>Thông Tin Sản Phẩm</h2>
      <input type="hidden" name="command" value="create" />
      <div class="form-group">
        <label>Tên sản phẩm</label>
        <input type="text" name="name" required />
      </div>
      <div class="form-group">
        <label>Danh mục</label>
        <select name="category">
          <option value="Nam">Thời Trang Nam</option>
          <option value="Nu">Thời Trang Nữ</option>
          <option value="Combo">Phụ kiện</option>
        </select>
      </div>
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
      <hr />
      <button type="submit">Lưu Sản Phẩm</button>
    </form>
  </body>
</html>
