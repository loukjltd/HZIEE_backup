<%--
  Created by IntelliJ IDEA.
  User: loukj
  Date: 2021/10/29
  Time: 8:52 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>水果购物车</title>
</head>
<style>
    h1 {
        float: left;
    }
    #lookCart {
        margin-top: 30px;
    }
    #fruitList {
        margin-top: 50px;
    }
</style>
<body>
    <%
        String[] goods = (String[])session.getAttribute("goods");
        StringBuilder temp = new StringBuilder();
        if (goods!=null) {
            for (String good : goods) {
            temp.append(",").append(good);
            }
        }
        System.out.println(temp);
    %>
    <form action="user.cart" method="post">
        <h1>水果列表</h1>
        <input type="submit" value="查看购物车" id="lookCart">
        <br>
        <div id="fruitList">
            <label>
                春季精选：
                <input type="checkbox" name="goods" value="草莓" <%=temp.toString().contains("草莓")? "checked" :""%>>草莓
                <input type="checkbox" name="goods" value="菠萝" <%=temp.toString().contains("菠萝")? "checked" :""%>>菠萝
                <input type="checkbox" name="goods" value="芒果" <%=temp.toString().contains("芒果")? "checked" :""%>>芒果
                <br>
                夏季精选：
                <input type="checkbox" name="goods" value="西瓜" <%=temp.toString().contains("西瓜")? "checked" :""%>>西瓜
                <input type="checkbox" name="goods" value="木瓜" <%=temp.toString().contains("木瓜")? "checked" :""%>>木瓜
                <input type="checkbox" name="goods" value="山竹" <%=temp.toString().contains("山竹")? "checked" :""%>>山竹
                <br>
                秋季精选：
                <input type="checkbox" name="goods" value="香梨" <%=temp.toString().contains("香梨")? "checked" :""%>>香梨
                <input type="checkbox" name="goods" value="山楂" <%=temp.toString().contains("山楂")? "checked" :""%>>山楂
                <input type="checkbox" name="goods" value="葡萄" <%=temp.toString().contains("葡萄")? "checked" :""%>>葡萄
                <br>
                冬季精选：
                <input type="checkbox" name="goods" value="樱桃" <%=temp.toString().contains("樱桃")? "checked" :""%>>樱桃
                <input type="checkbox" name="goods" value="榴莲" <%=temp.toString().contains("榴莲")? "checked" :""%>>榴莲
                <input type="checkbox" name="goods" value="芦柑" <%=temp.toString().contains("芦柑")? "checked" :""%>>芦柑
            </label>
        </div>


        <br><br><br>

    </form>
</body>
</html>
