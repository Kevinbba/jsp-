<%--
  Created by IntelliJ IDEA.
  User: 73107
  Date: 2020/5/25
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = request.getParameter("userName");
    request.setAttribute("userName", userName);
%>
<html>
<head>
    <title>新闻后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/NewAdminConShen.css">
</head>
<body>
<!-- 发布、修改、审核、提交 -->
<div class="all">
    <div class="leftPart">
        <div class="title">
            NewsAdmin
        </div>
        <div class="navImg">
            <img src="images/user.png" alt="">
            <div class="userInfo">
                尊敬的管理员<br />欢迎您
            </div>
        </div>
        <div class="nav">
            <ul class="navList">
                <a href="NewAdminPublish.jsp?userName=${userName}">
                    <li class="navItem">
                        <img src="images/publish.png" alt="">新闻发布
                    </li>
                </a>
                <a href="NewsListServlet?userName=${userName}">
                    <li class="navItem">
                        <img src="images/edit.png" alt="">新闻列表
                    </li>
                </a>
                <a href="ServletNewsShenhe?userName=${userName}">
                    <li class="navItem"  style="background-color: #2C7CE0;color: white">
                        <img src="images/shenhe.png" alt="">新闻审核
                    </li>
                </a>
            </ul>
        </div>
    </div>
    <div class="rightPart">
        <div class="header">
            <div class="header_content">
                <div class="button">
                    <div class="user">
                        <img src="images/user01.png" alt="">
                        <a href="UserloginServlet">${userName}</a>
                        <img src="images/tiaozhuan.png" alt="">
                        <a href="">前台页面</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="right_content">
            <div class="bgColor"></div>
            <div class="content">
                <div class="location">
                    当前位置：<span>新闻审核</span>>>
                    <span style="color: #2c7ce0;">新闻详情</span>
                </div>
                <div class="userOperation">
                    <div class="newsTitle">
                        新闻标题：${news.getTitle()}
                    </div>
                    <div class="newsContent">
                        <p class="newscontent1">新闻内容：</p><p class="newscontent">${news.getContent()}</p>
                    </div>
                    <div class="newClassify">
                        新闻分类：${news.getClassify()}
                    </div>
                    <div class="submit">
                        <input type="submit" value="返回" onclick='location.href=("ServletNewsShenhe?userName=${userName}")'/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
