package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginPage", value = "/loginPage")
public class loginPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String myUserName = request.getParameter("myUserName");
        String myPassword = request.getParameter("myPassword");
        if (myUserName.equals("loukejia") && "219350623".equals(myPassword)) {
            response.sendRedirect("loginSuccessPage.html");
        } else {
            System.out.println("登陆失败，正在重定向到登录页面...");
            response.sendRedirect("loginWebPage.html");
        }
    }
}
