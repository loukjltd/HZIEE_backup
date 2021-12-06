package com.loukj.finalhomework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Objects;

@WebServlet(name = "LogIn", value = "/LogIn")
public class LogIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String getUserName = request.getParameter("webUserNameLogIn");
        getUserName = GBK(getUserName);
        String getPassword = request.getParameter("webPasswordLogIn");
        getPassword = GBK(getPassword);

        Statement newSta = null;
        ResultSet newRst = null;
        Connection newConn = null;
        PreparedStatement newPrepSta = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/userinfo";
            String sqlUserName = "root";
            String sqlPassword = "root";
            newConn = DriverManager.getConnection(url, sqlUserName, sqlPassword);

            newSta = newConn.createStatement();
            String sqlSelectLang = "SELECT * FROM basicinfo";
            String sqlInsertLang = "INSERT INTO loggedin(username, password) VALUES(?,?)";
            assert false;
            newRst = newSta.executeQuery(sqlSelectLang);

            System.out.println("userName password");
            while (newRst.next()) {
                if (Objects.equals(newRst.getString("username"), getUserName) &&
                        Objects.equals(newRst.getString("password"), getPassword)) {
                    newPrepSta = newConn.prepareStatement(sqlInsertLang);
                    newPrepSta.setString(1, getUserName);
                    newPrepSta.setString(2, getPassword);
                    newPrepSta.executeUpdate();
                    response.sendRedirect("LogIn.jsp");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (newSta != null) {
                try {
                    newConn.close();
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
    }

    private String GBK(String properties) {
        properties = new String(properties.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return properties;
    }
}
