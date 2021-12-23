<%--
  Created by IntelliJ IDEA.
  User: loukj
  Date: 2021/10/21
  Time: 7:14 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="user.cart" method="post">
        商品列表：<br>
        <input type="checkbox" name="goods" value="足球">
        <input type="checkbox" name="goods" value="篮球">
        <input type="checkbox" name="goods" value="网球">
        <input type="checkbox" name="goods" value="羽球">
        <input type="submit" value="放入购物车">

    </form>
</body>
</html>
