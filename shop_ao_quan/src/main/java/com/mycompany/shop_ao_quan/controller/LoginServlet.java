/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.shop_ao_quan.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.mycompany.shop_ao_quan.service.*;

/**
 *
 * @author nguye
 */
public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            boolean isAuthenticated = loginService.authenticate(username, password);
            if (isAuthenticated) {
                session.setAttribute("username", username);
                request.setAttribute("success", "Login successful!");
            } else {
                request.setAttribute("error", "Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        request.setAttribute("error", "An error occurred during login.");
        }finally {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    
}
