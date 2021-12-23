package com.loukj.finalhomework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;


@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String getUserName = request.getParameter("webUserNameReg");
        getUserName = GBK(getUserName);
        String getPassword = request.getParameter("webPasswordReg");
        getPassword = GBK(getPassword);

        PreparedStatement newPrepSta = null;
        Connection newConn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/userinfo";
            String sqlUserName = "root";
            String sqlPassword = "root";
            newConn = DriverManager.getConnection(url, sqlUserName, sqlPassword);

            String sqlInsertLang = "INSERT INTO basicinfo(username, password) VALUES(?,?)";
            newPrepSta = newConn.prepareStatement(sqlInsertLang);
            newPrepSta.setString(1, getUserName);
            newPrepSta.setString(2, getPassword);
            newPrepSta.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (newPrepSta != null) {
                try {
                    newPrepSta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (newConn != null) {
                try {
                    newConn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        response.sendRedirect("RegisterSuccess.jsp");
    }

    private String GBK(String properties) {
        properties = new String(properties.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return properties;
    }
}

