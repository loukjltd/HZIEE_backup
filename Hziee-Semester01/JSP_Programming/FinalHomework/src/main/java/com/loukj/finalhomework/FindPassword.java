package com.loukj.finalhomework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.beans.SimpleBeanInfo;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "FindPassword", value = "/FindPassword")
public class FindPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("FindPassword.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String getUserName = request.getParameter("webUserNameFind");
        getUserName = GBK(getUserName);
        String getPassword = request.getParameter("webPasswordFind");
        getPassword = GBK(getPassword);

        Connection newConn = null;
        Statement newSta = null;
        ResultSet NewRst = null;
        try {
            newConn = JdbcUtils.getConnection();
            newSta = newConn.createStatement();
            String sqlFindPasswordLang = "UPDATE loggedin SET username='" + getUserName + "',password='" + getPassword + "'";
            newSta.executeUpdate(sqlFindPasswordLang);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(null, newSta, newConn);
        }
    }
    private String GBK(String properties) {
        properties = new String(properties.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return properties;
    }
}
