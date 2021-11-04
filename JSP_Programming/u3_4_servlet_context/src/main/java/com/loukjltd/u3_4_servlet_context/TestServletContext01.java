package com.loukjltd.u3_4_servlet_context;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.*;

@WebServlet(name = "TestServletContext01", value = "/TestServletContext01")
public class TestServletContext01 extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletContext context = this.getServletContext();
        Enumeration<String> paraNames = context.getInitParameterNames();
        out.println("all paraName and paraValue are following:" + "<br/>");
        while (paraNames.hasMoreElements()) {
            String name = paraNames.nextElement();
            String value = context.getInitParameter(name);
            out.println(name + ": " + value);
            out.println("<br/>");
        }
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
