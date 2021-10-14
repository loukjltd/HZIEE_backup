<%--
  Created by IntelliJ IDEA.
  User: loukj
  Date: 2021/10/14
  Time: 6:26 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String nickName = (String) request.getAttribute("nickName");
    String secretPassword = (String) request.getAttribute("secretPassword");
    System.out.println(nickName);
    System.out.println(secretPassword);
%>
</body>
</html>
