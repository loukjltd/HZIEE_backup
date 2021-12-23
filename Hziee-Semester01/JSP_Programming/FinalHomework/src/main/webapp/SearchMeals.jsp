<%@ page import="com.loukj.finalhomework.FoodInfo" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.loukj.finalhomework.FoodDB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>餐点搜索</title>
    <link rel="stylesheet" href="CSS/SearchMeals.css">
</head>
<body>
    <%@include file="TemplateHead.jsp"%>
    <div id="menuList">
        <div id="menuPart">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>推荐菜谱/Recommended Recipe</h2>
            <div>
                <ul>
                    <%
                        response.setContentType("text/html;charset=utf-8");
                        Collection<FoodInfo> getFood = FoodDB.getAll();

                        for (FoodInfo newFood : getFood) {
                            out.write("<li>");
                            String url = "FoodPurchase?foodNo=" + newFood.getFoodNo();
                            out.write("<a href=" + url + ">");

                            out.write("<img src=\"ImageFiles/" + newFood.getFoodName() + ".jpeg\" alt=\"新品暂无图片\">");

                            out.write("<h3>" + newFood.getFoodName() + "</h3>");
                            out.write("<p class=\"englishName\">" + newFood.getFoodNameEng() + "</p>");
                            out.write("<p class=\"price\">" + newFood.getPrice() + "</p>");
                            out.write("</a>");
                            out.write("</li>");
                        }
                    %>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
