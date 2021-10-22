package com.loukjltd.u5_conversation_technology;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "*.login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("test.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);

        if ("admin".equals(userName) && "123".equals(pwd)) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/index.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
