<%--
  Created by IntelliJ IDEA.
  User: loukj
  Date: 2021/10/21
  Time: 6:57 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String userName = (String) session.getAttribute("userName");
    System.out.print("欢迎管理员" + userName);
%>
</body>
</html>
