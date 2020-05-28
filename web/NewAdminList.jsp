<%--
  Created by IntelliJ IDEA.
  User: 73107
  Date: 2020/5/25
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page  import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="servlet.NewsListServlet" %>
<%
    String userName = request.getParameter("userName");
    request.setAttribute("userName", userName);
%>
<html>
<head>
    <title>新闻后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/NewAdminEdit.css">
    <script src="js/NewAdminList.js" type="text/javascript" charset="utf-8"></script>
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
                    <li class="navItem"  style="background-color: #2C7CE0;color: white">
                        <img src="images/edit.png" alt="">新闻列表
                    </li>
                </a>
                <a href="ServletNewsShenhe?userName=${userName}">
                    <li class="navItem">
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
                    当前位置：<span style="color: #2c7ce0;">新闻编辑</span>
                </div>
                <div class="userOperation">
                    <%--EL表达式--%>
                    <table border="1" cellpadding="10" cellspacing="0">
                        <tr class="center">
                            <td class="one">序号</td>
                            <td class="two">新闻标题</td>
                            <td class="three">新闻内容</td>
                            <td class="four">新闻分类</td>
                            <td class="five">新闻状态</td>
                            <td class="six">操作</td>
                        </tr>

                        <%
                        %>
                        <c:forEach items="${list}" var="news">
                            <tr>
                                <td class="one">${news.id}</td>
                                <td class="two"><div>${news.title}</div></td>
                                <td class="three"><div>${news.content}</div></td>
                                <td class="four">${news.classify}</td>
                                <td class="five">${news.status}</td>
                                <td class="six">
                                    <a href="ServletViewNews?id=${news.id}&userName=${userName}">编辑</a>&nbsp;|
                                    <a href="ServletNewsDelete?id=${news.id}&userName=${userName}" onclick="showDel()">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>


                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
