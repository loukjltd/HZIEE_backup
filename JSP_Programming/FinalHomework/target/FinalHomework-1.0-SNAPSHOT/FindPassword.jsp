<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/FindPassword.css">
</head>
<body>
    <%@include file="TemplateHead.jsp"%>
    <div id="specInfo">
        <div id="findPart">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>找回密码/Find Password</h2>
            <div id="userPwdFind">
                <form action="FindPassword" method="post">
                    <label>
                        <span>账户 Username：</span>
                        <input type="text" placeholder="小写英文、数字为组合" name="webUserNameFind">
                        <br><br>
                        <span>密码 Password：</span>
                        <input type="password" placeholder="大小写字母、数字及特殊符号" name="webPasswordFind">
                        <br><br>
                        <input type="submit" value="确认找回 Confirm" name="findPassword">
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <input type="reset" value="重新填写 Reset">
                    </label>
                </form>
            </div>
        </div>

        <div id="loginPart">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>用户登录/User Login</h2>
            <div id="userPwdLogin">
                <form action="LogIn" method="post">
                    <label>
                        <span>账户 Username：</span>
                        <input type="text" placeholder="小写英文、数字为组合" name="webUserNameLogIn">
                        <br><br>
                        <span>密码 Password：</span>
                        <input type="password" placeholder="大小写字母、数字及特殊符号" name="webPasswordLogIn">
                        <br><br>
                        <input type="submit" value="登陆 Login" name="loginInfo">
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <input type="reset" value="重新填写 Reset">
                    </label>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
