package com.myapp.servlet;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*; // Tomcat 10
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/userservlet")
public class UserServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            registerUser(request, response);
        } else if ("login".equals(action)) {
            loginUser(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("logout".equals(action)) {
            logoutUser(request, response);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/im2073mobileproj", "myuser",
                "xxxx")) {
            String sql = "INSERT INTO teachers (EMAIL,PASS) VALUES(?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.executeUpdate();
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("pages/home.html");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("loginerror.jsp");
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            // Explicitly load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/im2073mobileproj";
            Connection conn = DriverManager.getConnection(url, "myuser", "xxxx");

            String sql = "SELECT * FROM teachers WHERE EMAIL=? AND PASS=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            System.out.println("Executing query: " + sql); // Log the query

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int teacherId = rs.getInt("TEACHER_ID");
                System.out.println("teacher id is " + teacherId);
                HttpSession session = request.getSession();
                session.setAttribute("teacherId", teacherId);
                response.sendRedirect("pages/home.jsp");
            } else {
                String message = "Password wrong! Please try again";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("loginerror.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("loginerror.jsp");
        }
    }

    private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("pages/login.jsp");
    }

}