<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>餐点搜索</title>
    <link rel="stylesheet" href="CSS/SearchMeals.css">
</head>
<body>
    <%@include file="TemplateHead.jsp"%>
    <div id="menuList">
        <div id="menuPart">
            <img src="${pageContext.request.contextPath}/ImageFiles/SmallLogo.png" alt="Small Logo"/>
            <h2>推荐菜谱/Recommended Recipe</h2>
            <div>
                <ul>
                    <li>
                        <a href="#">
                            <img src="ImageFiles/口水猪肝.jpeg" alt="Main Image">
                            <h3>口水猪肝</h3>
                            <p class="englishName">The Saliva Pork Liver</p>
                            <p class="price">￥23</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="ImageFiles/姜爆鸭子.jpeg" alt="Main Image">
                            <h3>姜爆鸭子</h3>
                            <p class="englishName">Ginger Duck Blasting</p>
                            <p class="price">￥18</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="ImageFiles/家常干锅排骨.jpeg" alt="Main Image">
                            <h3>家常干锅排骨</h3>
                            <p class="englishName">Homemade Dry Pot Ribs</p>
                            <p class="price">￥32</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="ImageFiles/干煸四季豆.jpeg" alt="Main Image">
                            <h3>干煸四季豆</h3>
                            <p class="englishName">Stir-fried green beans</p>
                            <p class="price">￥8</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
