package com.loukjltd.u5_conversation_technology;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = "*.cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String[] goods = request.getParameterValues("goods");
        HttpSession session = request.getSession();
        session.setAttribute("goods", goods);
        response.sendRedirect("cart.jsp");
    }
}
