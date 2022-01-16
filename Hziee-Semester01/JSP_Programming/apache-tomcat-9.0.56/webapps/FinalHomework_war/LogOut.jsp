<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销登陆</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/LogOut.css">
</head>
<body>
    <%@include file="TemplateHead.jsp"%>
    <div id="specInfo">
        <div id="LogOutPart">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>退出登录/Log Out</h2>
            <div id="userLogOut">
                <form action="LogOut" method="post">
                    <label>
                        <input type="submit" value="是否确认？" name="confirmLogOut">
                    </label>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
