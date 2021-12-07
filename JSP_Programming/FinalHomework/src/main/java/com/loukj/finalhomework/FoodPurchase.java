package com.loukj.finalhomework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FoodPurchase", value = "/FoodPurchase")
public class FoodPurchase extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodNo = request.getParameter("foodNo");
        if (foodNo == null) {
            String url = "FoodList";
            response.sendRedirect(url);
            return;
        }
        FoodInfo getFood = FoodDB.getFood(foodNo);
        HttpSession newSession = request.getSession();
        List<FoodInfo> foodInfoList = (List)newSession.getAttribute("foodInfoList");
        if (foodInfoList == null) {
            foodInfoList = new ArrayList<FoodInfo>();
            newSession.setAttribute("foodInfoList", foodInfoList);
        }
        foodInfoList.add(getFood);
        Cookie newCookie = new Cookie("JESSIONID", newSession.getId());
        newCookie.setMaxAge(60 * 30);
        newCookie.setPath("/");
        response.addCookie(newCookie);
        String url = "/AddCart";
        response.sendRedirect(url);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
