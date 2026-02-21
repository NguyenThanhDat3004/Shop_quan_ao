package com.mycompany.shop_ao_quan.controller;

import com.mycompany.shop_ao_quan.model.Product;
import com.mycompany.shop_ao_quan.service.ProductService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import java.io.File;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
@MultipartConfig
public class AdminCommand extends HttpServlet {

     private ProductService service;

    @Override
    public void init() {
        service = new ProductService();
    }
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String command = request.getParameter("command");
        try {
            switch (command) {
                case "create":
                    request.getRequestDispatcher("add-product.jsp")
                   .forward(request, response);
                    break;
                case "update":
                    request.getRequestDispatcher("update-product.jsp")
                   .forward(request, response);
                    break;
                case "delete":
                    request.getRequestDispatcher("delete-product.jsp")
                   .forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Có lỗi xảy ra!");
            request.getRequestDispatcher("home-page.jsp")
                   .forward(request, response);
        }
}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        switch (command) {
                case "create":
                try {
                    this.addProduct(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(AdminCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
                    break;
                case "update":
                    request.getRequestDispatcher("update-product.jsp")
                   .forward(request, response);
                    break;
                case "delete":
                    request.getRequestDispatcher("delete-product.jsp")
                   .forward(request, response);
                    break;
    }
    }

// cac ham thuc thi
    private void addProduct(HttpServletRequest request, HttpServletResponse response)
            throws Exception, ServletException, IOException {
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        // bien flag
        boolean success = false;
        String baseImageDir = "C:/imgForShop";
        String posterUrl = "C:/imgForShop/default.jpg"; // cho mot anh mac dinh o day
        try {
            Part posterPart = request.getPart("poster");
            String fileName = "";
            if (posterPart != null && posterPart.getSize() > 0) {
                fileName = System.currentTimeMillis() + "_"
                        + Paths.get(posterPart.getSubmittedFileName())
                                .getFileName().toString();
                posterUrl = fileName;
            }
            // insert db truoc moi luu file
           Product p = new Product(name, category, fileName);
           service.addProduct(p);
            // insert thanh cong moi luu file ve server
            if (posterPart != null && posterPart.getSize() > 0) {
                File dir = new File(baseImageDir);
                if (!dir.exists()) {
                    dir.mkdirs(); // tao thu muc luu anh neu chua co
                }
                posterPart.write(baseImageDir + File.separator + fileName);
            }
            success = true;
            request.setAttribute("msg", "Thêm phim thành công!");
            request.setAttribute("error", "");
        request.getRequestDispatcher("add-product.jsp")
               .forward(request, response);
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
        }
    }

    // =============================
    // UPDATE
    // =============================
    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws Exception, IOException {

        Product p = new Product();
        p.setProductId(Integer.parseInt(request.getParameter("id")));
        p.setName(request.getParameter("name"));
        p.setCategory(request.getParameter("category"));
        p.setImageUrl(request.getParameter("imageUrl"));
        service.updateProduct(p);
        response.sendRedirect("products");
    }
    // =============================
    // DELETE
    // =============================
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws Exception, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteProduct(id);
        response.sendRedirect("products");
    }
}