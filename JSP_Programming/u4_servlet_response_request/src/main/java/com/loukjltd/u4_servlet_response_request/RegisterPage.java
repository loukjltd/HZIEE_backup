package com.loukjltd.u4_servlet_response_request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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
        response.setContentType("text/html; charset=UTF-8");
        // 这段内容将输出在服务器后台
        Enumeration<String> getEnum = request.getParameterNames();
        while (getEnum.hasMoreElements()) {
            String getParaName = getEnum.nextElement();
            String getParaValue = request.getParameter(getParaName);
            out.println(getParaName + " == " + getParaValue);
        }
        response.sendRedirect("registerSuccessPage.html");

        PrintWriter out = response.getWriter();
        String nickName = request.getParameter("nickName");
        nickName = GBK(nickName);
        String secretPassword = request.getParameter("secretPassword");
        secretPassword = GBK(secretPassword);
        String areaName = request.getParameter("areaName");
        areaName = GBK(areaName);

        out.println("昵称：" + nickName);
        out.println("密码：" + secretPassword);
        out.println("地区：" + areaName);

    }

    private String GBK(String properties) {
        properties = new String(properties.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return properties;
    }
}
