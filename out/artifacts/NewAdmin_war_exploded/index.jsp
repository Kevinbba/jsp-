<%--
  Created by IntelliJ IDEA.
  User: 73107
  Date: 2020/5/25
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>NewsAdminLogin</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
  </head>
  <body>
  <div class="all">
    <div class="login">
      <form action="UserloginServlet" method="get">
        <div class="title_img">
          <img src="images/user.png" alt="">
        </div>
        <div class="title">
          NewsAdmin
        </div>
        <div class="username">
          <input type="text" name="userName" placeholder="Username"/>
        </div>
        <div class="userpassword">
          <input type="password" name="userPassword" placeholder="Password"/>
          <span class="tips">${message}</span>
        </div>
        <div class="submit">
          <input type="submit" value="登录" />
        </div>
      </form>
    </div>
  </div>
  </body>
</html>
