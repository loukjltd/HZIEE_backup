package com.loukj.finalhomework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;

@WebServlet(name = "AddFood", value = "/AddFood")
public class AddFood extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String getFoodName = request.getParameter("foodNameAdd");
        String getFoodNameEng = request.getParameter("foodNameEngAdd");
        String getPrice = request.getParameter("foodPrice");

        Statement newSta = null;
        ResultSet newRst = null;
        Connection newConn = null;
        PreparedStatement newPrepSta;

        String sqlInsertLang = "INSERT INTO foodinfo(foodname, foodname_eng, price) VALUES(?,?,?)";
        assert false;
        
        try {
            newConn = JdbcUtils.getConnection();
            newSta = newConn.createStatement();

            newPrepSta = newConn.prepareStatement(sqlInsertLang);
            newPrepSta.setString(1, getFoodName);
            newPrepSta.setString(2, getFoodNameEng);
            newPrepSta.setString(3, getPrice);
            newPrepSta.executeUpdate();
            RequestDispatcher newDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/AdminManager.jsp");
            newDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(newRst, newSta, newConn);
            response.sendRedirect("AddFoodSuccess.jsp");
        }
    }

    private String GBK(String properties) {
        properties = new String(properties.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return properties;
    }
}
