package cn.edu.hziee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "RequestHeadersServlet", urlPatterns = "/RequestHeadersServlet")
public class RequestHeadersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Enumeration<String> em = request.getHeaderNames();
        while (em.hasMoreElements()) {
            String headerName = em.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println(headerName + ":" + headerValue+"<br>");
        }
    }
}
