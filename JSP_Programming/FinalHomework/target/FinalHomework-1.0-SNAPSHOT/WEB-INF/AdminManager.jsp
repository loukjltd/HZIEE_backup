<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.loukj.finalhomework.FoodInfo" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.loukj.finalhomework.FoodDB" %>
<html>
<head>
    <title>后台管理页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/AdminManager.css">
</head>
<body>
    <div id="topTitle">
        <h1>在线点餐后台管理系统 Online Ordering Back Management System</h1>
    </div>

    <div id="updatePart">
        <div id="addPart">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>添加菜品/Add Recipe</h2>
            <div id="addNamePrice">
                <form action="AddFood" method="post">
                    <label>
                        <span>菜品名称 Name：</span>
                        <input type="text" placeholder="请输入菜品名称" name="foodNameAdd">
                        <br><br>
                        <span>English Name：</span>
                        <input type="text" placeholder="Please Enter English Name" name="foodNameEngAdd">
                        <br><br>
                        <span>价格 Price：</span>
                        <input type="text" placeholder="请输入价格" name="priceAdd">
                        <br><br>
                        <input type="submit" value="确认添加 Confirm" name="confirmAddInfo">
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <input type="reset" value="重新填写 Reset">
                    </label>
                </form>
            </div>
        </div>

        <div id="removePart">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>移除菜品/Remove Recipe</h2>
            <div id="removeNamePrice">
                <form action="RemoveFood" method="post">
                    <label>
                        <span>菜品名称 Name：</span>
                        <input type="text" placeholder="请输入菜品名称" name="foodNameRemove">
                        <br><br>
                        <input type="submit" value="确认删除 Confirm" name="confirmInfoRemove">
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <input type="reset" value="重新填写 Reset">
                    </label>
                </form>
            </div>
        </div>
    </div>

    <div id="menuList">
        <div id="menuPart">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>所有菜品/All Recipe</h2>
            <div>
                <ul>
                    <%
                        response.setContentType("text/html;charset=utf-8");
                        Collection<FoodInfo> getFood = FoodDB.getAll();

                        for (FoodInfo newFood : getFood) {
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
                    %>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
