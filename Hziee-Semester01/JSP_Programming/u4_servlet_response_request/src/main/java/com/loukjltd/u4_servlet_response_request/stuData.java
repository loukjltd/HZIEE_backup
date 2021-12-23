package com.loukjltd.u4_servlet_response_request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "stuData", urlPatterns = "*.stuData")
public class stuData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickName = request.getParameter("nickName");
        request.setAttribute("nickName", nickName);
        String secretPassword = request.getParameter("secretPassword");
        request.setAttribute("secretPassword", secretPassword);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ok.jsp");
        rd.forward(request, response);

//        String[] hobby = {"篮球", "足球"};
//        request.setAttribute("hobby", hobby);

//        String name = (String) request.getAttribute("name");
//        int age = Integer.parseInt((String) request.getAttribute("age"));
//        String[] hobbies = (String[]) request.getAttribute("hobby");
//        System.out.println(name);
//        System.out.println(age);
//        for (String s : hobbies) {
//            System.out.println(s);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
