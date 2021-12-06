<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" href="CSS/Index.css">
</head>
<body>
    <%@include file="TemplateHead.jsp"%>

    <div id="specInfo">
        <div id="menuRecommend">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>本周菜品推荐/Weekly Recommendation</h2>
            <ul>
                <li>
                    <a href="#">水煮肉片 Boiled meat</a>
                    <span>￥29</span>
                </li>
                <li>
                    <a href="#">鱼香肉丝 Braised pork</a>
                    <span>￥19</span>
                </li>
                <li>
                    <a href="#">酸菜鱼 Pickled fish</a>
                    <span>￥39</span>
                </li>
                <li>
                    <a href="#">剁椒鱼头 Chilli fish head</a>
                    <span>￥59</span>
                </li>
                <li>
                    <a href="#">东坡肉 Soysauced dongpo pork</a>
                    <span>￥49</span>
                </li>
                <li>
                    <a href="#">白切鸡 Boiled chicken slices</a>
                    <span>￥99</span>
                </li>
            </ul>
        </div>
        <div id="loginPart">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>用户登录/User Login</h2>
            <div id="userPwdLogin">
                <form>
                    <label>
                        <span>账户 Username：</span>
                        <input type="text" placeholder="小写英文、数字为组合">
                        <br><br>
                        <span>密码 Password：</span>
                        <input type="password" placeholder="大小写字母、数字及特殊符号">
                        <br><br>
                        <input type="submit" value="登陆 Login">
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <input type="reset" value="重新填写 Reset">
                    </label>
                </form>
            </div>
        </div>
    </div>





</body>
</html>
