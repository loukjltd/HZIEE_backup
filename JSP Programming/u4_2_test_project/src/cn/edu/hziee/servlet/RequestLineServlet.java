package cn.edu.hziee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RequestLineServlet", urlPatterns = "/RequestLineServlet")
public class RequestLineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
// http://localhost:8080/unit4_2_war_exploded/RequestLineServlet?name=admin&pwd=123&date=2021
        //GET
        String method = request.getMethod();
        out.println("method=="+method+"<br>");

        //  /unit4_2_war_exploded/RequestLineServlet
        String requestURI = request.getRequestURI();
        out.println("requestURI=="+requestURI+"<br>");

        //  http://localhost:8080/unit4_2_war_exploded/RequestLineServlet
        StringBuffer requestURL = request.getRequestURL();
        out.println("requestURL=="+requestURL+"<br>");

        //  name=admin&pwd=123&date=2021
        String queryString = request.getQueryString();
        out.println("queryString=="+queryString+"<br>");

        //  HTTP/1.1
        String protocol = request.getProtocol();
        out.println("protocol=="+protocol+"<br>");

        //  /unit4_2_war_exploded
        String contextPath = request.getContextPath();
        out.println("contextPath=="+contextPath+"<br>");

        //  /RequestLineServlet
        String servletPath = request.getServletPath();
        out.println("servletPath=="+servletPath+"<br>");

        //  IPV4 127.0.0.1   IPV6 0:0:0:0:0:0:0:1
        String remoteAddr = request.getRemoteAddr();
        out.println("remoteAddr=="+remoteAddr+"<br>");

    }
}
