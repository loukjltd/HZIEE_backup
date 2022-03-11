<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.loukj.finalhomework.JdbcUtils" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>

<html>
<head>
    <title>用户中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/UserCenter.css">
</head>
<body>
    <%@include file="TemplateHead.jsp"%>
    <div id="specInfo">
        <div id="userInfoPart">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>已登录用户信息/Information About The User That Has Logged In</h2>
            <%
                Connection newConn = null;
                Statement newSta = null;
                ResultSet newRst = null;
                try {
                    newConn = JdbcUtils.getConnection();
                    newSta = newConn.createStatement();
                    String sqlSelectLang = "SELECT * FROM loggedin";
                    newRst = newSta.executeQuery(sqlSelectLang);

                    while (newRst.next()) {
                        out.print("<div id='userCenterPart'>");
                        out.print("<p>账户：");
                        String getUserName = newRst.getString("username");
                        out.print(getUserName);
                        out.print("</p>");
                        out.print("<p>密码：");
                        String getPassword = newRst.getString("password");
                        out.print(getPassword);
                        out.print("</p>");
                        out.print("</div>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JdbcUtils.release(newRst, newSta, newConn);
                }
            %>
        </div>
    </div>
</body>
</html>
