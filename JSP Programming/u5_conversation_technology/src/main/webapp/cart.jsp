<%--
  Created by IntelliJ IDEA.
  User: loukj
  Date: 2021/10/21
  Time: 7:18 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车内容</title>
</head>
<body>
<%
    String[] goods = (String[]) session.getAttribute("goods");
    for (String good : goods) {
        System.out.print(good+"<br>");
    }
%>
<hr>
</body>
</html>
