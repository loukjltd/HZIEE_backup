package com.loukj.finalhomework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;

@WebServlet(name = "RemoveFood", value = "/RemoveFood")
public class RemoveFood extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String getFoodName = request.getParameter("foodNameRemove");

        Statement newSta = null;
        Connection newConn = null;

        try {
            newConn = JdbcUtils.getConnection();
            newSta = newConn.createStatement();

            String sqlDelLang = "DELETE FROM foodinfo WHERE foodname='" + getFoodName + "'";
            assert false;
            newSta.executeUpdate(sqlDelLang);

            RequestDispatcher newDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/AdminManager.jsp");
            newDispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(null, newSta, newConn);
            response.sendRedirect("RemoveFoodSuccess.jsp");
        }

    }

    private String GBK(String properties) {
        properties = new String(properties.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return properties;
    }
}
