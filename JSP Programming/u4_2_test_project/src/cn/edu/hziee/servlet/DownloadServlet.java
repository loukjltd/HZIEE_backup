package cn.edu.hziee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DownloadServlet", urlPatterns = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("referer");
        String contextPath = request.getContextPath();

        System.out.println("referer==="+referer);
        System.out.println("contextPath==="+contextPath);

        if (referer!=null&&referer.contains(contextPath)) {
            System.out.println("合法下载");
        }else{
            System.out.println("非法盗链");
        }
    }
}
