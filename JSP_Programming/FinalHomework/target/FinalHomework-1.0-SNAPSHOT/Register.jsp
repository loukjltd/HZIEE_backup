<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="CSS/Register.css">
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
        <div id="registerPart">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>用户注册/User Registration</h2>
            <div id="userPwdRegister">
                <form>
                    <label>
                        <span>账户 Username：</span>
                        <input type="text" placeholder="小写英文、数字为组合">
                        <br><br>
                        <span>密码 Password：</span>
                        <input type="password" placeholder="大小写字母、数字及特殊符号">
                        <br><br>
                        <input type="submit" value="注册 Register">
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

    <div id="returnDbInfo">
        <%
            Statement newSta = null;
            ResultSet newRst = null;
            Connection newConn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/userinfo";
                String username = "root";
                String password = "root";
                newConn = DriverManager.getConnection(url, username, password);
                newSta = newConn.createStatement();
                String sqlLang = "select * from basicinfo";
                newRst = newSta.executeQuery(sqlLang);
                System.out.println("userNo userName password sex age");
                while (newRst.next()) {
                    int userNo = newRst.getInt("userno");
                    String userName = newRst.getString("username");
                    String userPassword = newRst.getString("password");
                    String userSex = newRst.getString("sex");
                    int userAge = newRst.getInt("age");
                    System.out.println(userNo + userName + userPassword + userSex + userAge);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        %>
    </div>
</body>
</html>
