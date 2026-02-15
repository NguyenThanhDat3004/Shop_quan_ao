/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.shop_ao_quan.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 *
 * @author nguye
 */
@WebServlet("/image")
public class ImageServlet extends HttpServlet {

    private static final String IMAGE_DIR = "C:/imgForShop";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = request.getParameter("name");
        if (fileName == null || fileName.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        File imageFile = new File(IMAGE_DIR, fileName);
        if (!imageFile.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // set content type (auto theo duoi anh)
        String mimeType = getServletContext().getMimeType(imageFile.getName());
        if (mimeType == null) {
            mimeType = "image/jpeg";
        }
        response.setContentType(mimeType);
        response.setContentLengthLong(imageFile.length());

        try (FileInputStream fis = new FileInputStream(imageFile);
             OutputStream os = response.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        }
    }


}
