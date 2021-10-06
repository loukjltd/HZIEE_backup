package cn.edu.hziee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "RegServlet", urlPatterns = "*.reg")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Map<String,String[]> map = request.getParameterMap();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String[] values = map.get(key);
            for (String value : values) {
                out.println(key+"=="+value+"<br>");
            }
        }

       /* Enumeration<String> em = request.getParameterNames();
        while (em.hasMoreElements()) {
            String paramName = em.nextElement();
            String paramValue = request.getParameter(paramName);
            out.println(paramName+"=="+paramValue+"<br>");
        }*/
       /* String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String gender = request.getParameter("gender");
        out.println(userName+"<br>");
        out.println(pwd+"<br>");
        out.println(gender+"<br>");
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            out.println(hobby+"<br>");
        }*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
