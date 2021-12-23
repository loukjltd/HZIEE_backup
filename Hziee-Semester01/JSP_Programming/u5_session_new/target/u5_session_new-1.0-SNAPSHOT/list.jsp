<%--
  Created by IntelliJ IDEA.
  User: loukj
  Date: 2021/10/29
  Time: 8:52 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String[] goods = (String[])session.getAttribute("goods");
        String temp = "";
        if (goods!=null) {
            for (String good : goods) {
            temp += ","+good;
            }
        }
        System.out.println(temp);
    %>
    <form action="user.cart" method="post">
        商品列表：<br>
        <input type="checkbox" name="goods" value="足球" <%=temp.contains("足球")? "checked" :""%>>足球
        <input type="checkbox" name="goods" value="篮球" <%=temp.contains("篮球")? "checked" :""%>>篮球
        <input type="checkbox" name="goods" value="网球" <%=temp.contains("网球")? "checked" :""%>>网球
        <input type="submit" value="放入购物车">
    </form>
</body>
</html>
