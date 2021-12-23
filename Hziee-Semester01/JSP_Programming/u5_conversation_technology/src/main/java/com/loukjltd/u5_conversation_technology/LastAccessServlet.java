package com.loukjltd.u5_conversation_technology;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LastAccessServlet", urlPatterns = "*.last")
public class LastAccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String lastAccessTime = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("lastAccess".equals(cookie.getName())) {
                lastAccessTime = cookie.getValue();
                break;
            }
        }

        if (lastAccessTime == null) {
            out.println("欢迎首次访问");
        } else {
            out.println("欢迎再次访问，上次的访问时间为：" + lastAccessTime);
        }

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
        String currentTime = sdf.format(date);
        Cookie cookie = new Cookie("lastAccess", currentTime);
        response.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
