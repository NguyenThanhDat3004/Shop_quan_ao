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
import com.mycompany.shop_ao_quan.model.Employee;
import com.mycompany.shop_ao_quan.service.*;

/**
 *
 * @author nguye
 */
public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String command = request.getParameter("command");
         if (command == null) {
            command = "login";
        }
        switch (command) {
            case "login":
                handleLogin(request, response, session);
                break;
            case "register":
                handleRegister(request, response);
                break;
        }
    }

    // ham login
    private void handleLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Employee employee = loginService.authenticate(username, password);
            if (employee != null) {
                session.setAttribute("employeeId", employee.getEmployeeId());
                request.setAttribute("success", "Login successful!");
            } else {
                request.setAttribute("error", "Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred during login.");
        } finally {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // ham register
    private void handleRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        try {
            loginService.register(username, password, name, role);
            request.setAttribute("success", "Registration successful! You can now log in.");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred during registration.");
        }finally {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
