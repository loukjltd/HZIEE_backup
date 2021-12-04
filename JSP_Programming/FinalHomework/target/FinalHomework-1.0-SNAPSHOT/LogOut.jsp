<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销登陆</title>
    <link rel="stylesheet" href="CSS/LogOut.css">
</head>
<body>
    <div id="topTitle">
        <h1>在线点餐系统 Online Ordering System</h1>
    </div>

    <div id="navBar">
        <ul>
            <li><a href="Index">首页</a></li>
            <li>|</li>
            <li><a href="Register">用户注册</a></li>
            <li>|</li>
            <li><a href="UserCenter">用户中心</a></li>
            <li>|</li>
            <li><a href="FindPassword">找回密码</a></li>
            <li>|</li>
            <li><a href="SearchMeals">餐点搜索</a></li>
            <li>|</li>
            <li><a href="AddCart">购物车</a></li>
            <li>|</li>
            <li><a href="LogOut">注销退出</a></li>
        </ul>
    </div>

    <div id="mainImage">
        <img src="${pageContext.request.contextPath}/ImageFiles/MainImage.JPG" alt="Main Image"/>
    </div>
</body>
</html>
