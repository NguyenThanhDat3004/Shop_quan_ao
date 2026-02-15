package com.mycompany.shop_ao_quan.controller;

import com.mycompany.shop_ao_quan.model.Product;
import com.mycompany.shop_ao_quan.service.ProductService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class AdminCommand extends HttpServlet {

     private ProductService service;

    @Override
    public void init() {
        service = new ProductService();
    }
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    request.getRequestDispatcher("add-product.jsp")
           .forward(request, response);
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String command = request.getParameter("command");

        if (command == null) {
            response.sendRedirect("add-product.jsp");
            return;
        }
        try {
            switch (command) {
                case "add":
                    addProduct(request, response);
                    break;
                case "update":
                    updateProduct(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
                default:
                    response.sendRedirect("add-product.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Có lỗi xảy ra!");
            request.getRequestDispatcher("add-product.jsp")
                   .forward(request, response);
        }
    }

    // =============================
    // ADD
    // =============================
    private void addProduct(HttpServletRequest request, HttpServletResponse response)
            throws Exception, ServletException, IOException {

        Product p = new Product();
        p.setName(request.getParameter("name"));
        p.setCategory(request.getParameter("category"));
        p.setImageUrl(request.getParameter("imageUrl"));
        service.addProduct(p);
        request.setAttribute("success", "Thêm sản phẩm thành công!");
        request.getRequestDispatcher("add-product.jsp")
               .forward(request, response);
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