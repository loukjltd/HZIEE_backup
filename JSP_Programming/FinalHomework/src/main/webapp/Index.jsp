<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" href="CSS/Index.css">
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
