<%--
  Created by IntelliJ IDEA.
  User: loukj
  Date: 2021/10/29
  Time: 8:51 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>以下水果已加入您的购物车！</h1>
    <%
        String[] goods = (String[])session.getAttribute("goods");
        for (String good : goods) {
            out.print("- " + good + "<br>");
        }
    %>
    <br><br>
    <a href="shop.jsp" id="continueShopping">继续购物</a>
</body>
</html>
