package com.loukjltd.u4_servlet_response_request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

import static java.lang.System.out;

@WebServlet(name = "RegisterPage", urlPatterns = "*.registerWebPage")
public class RegisterPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");  // 更改编码格式为UTF-8，以便显示中文
        // 这段内容将输出在服务器后台
        Enumeration<String> getEnum = request.getParameterNames();
        while (getEnum.hasMoreElements()) {
            String getParaName = getEnum.nextElement();
            String getParaValue = request.getParameter(getParaName);
            out.println(getParaName + " == " + getParaValue);
        }
        response.sendRedirect("registerSuccessPage.html");



    }
}
