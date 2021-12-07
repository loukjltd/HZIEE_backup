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
    <%
        response.setContentType("text/html;charset=utf-8");
        List<FoodInfo> foodInfoList = null;
        boolean purchaseFlag = false;
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
            out.write("对不起！您没有购买任何食品！");
        } else {
            out.write("您购买的食品有：<br>");
            double price = 0;
            for (FoodInfo newFood : foodInfoList) {
                out.write(newFood.getFoodName() + "<br>");
            }
        }
    %>
</body>
</html>
