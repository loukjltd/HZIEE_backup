package com.loukj.finalhomework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LogOut", value = "/LogOut")
public class LogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("LogOut.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        Statement newSta = null;
        Connection newConn = null;
        ResultSet newRst = null;

        try {
            newConn = JdbcUtils.getConnection();
            newSta = newConn.createStatement();

            String sqlDelLang = "DELETE FROM loggedin WHERE userno = 1";
            assert false;
            newSta.executeUpdate(sqlDelLang);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(null, newSta, newConn);
            response.sendRedirect("LogOutSuccess.jsp");
        }


    }
}
