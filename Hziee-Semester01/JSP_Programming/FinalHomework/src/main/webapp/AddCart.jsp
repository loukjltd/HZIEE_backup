<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.loukj.finalhomework.FoodInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="javafx.print.Collation" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="CSS/AddCart.css">
</head>
<body>
    <%@include file="TemplateHead.jsp"%>
    <div id="purchasedList">
        <div id="purchasedPart">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>已放入购物车的菜品/Items That Have Been Added To Shopping Cart</h2>
            <ul>
                <%
                    response.setContentType("text/html;charset=utf-8");
                    List<FoodInfo> foodInfoList = null;
                    boolean purchaseFlag = true;
                    HttpSession newSession = request.getSession(false);
                    if (newSession == null) {
                        purchaseFlag = false;
                    } else {
                        foodInfoList = (List) newSession.getAttribute("foodInfoList");
                        if (foodInfoList == null) {
                            purchaseFlag = false;
                        }
                    }
                    if (!purchaseFlag) {
                        out.write("<h2>对不起，您未添加任何菜品！</h2>");
                        out.write("<a href=\"SearchMeals.jsp\">点此返回菜单</a>");
                    } else {
                        double price = 0;
                        for (FoodInfo newFood : foodInfoList) {
                            out.write("<li>");
                            String url = "FoodPurchase?foodNo=" + newFood.getFoodNo();
                            out.write("<a href=" + url + ">");
                            out.write("<img src=\"ImageFiles/" + newFood.getFoodName() + ".jpeg\" alt=\"Main Image\">");
                            out.write("<h3>" + newFood.getFoodName() + "</h3>");
                            out.write("<p class=\"englishName\">" + newFood.getFoodNameEng() + "</p>");
                            out.write("<p class=\"price\">" + newFood.getPrice() + "</p>");
                            out.write("</a>");
                            out.write("</li>");
                        }
                    }
                %>
            </ul>
        </div>
    </div>

</body>
</html>
