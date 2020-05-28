<%--
  Created by IntelliJ IDEA.
  User: 73107
  Date: 2020/5/25
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page  import="java.sql.*" %>
<%@ page import="News.News" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>数据库请求</title>
</head>
<body>
<%
    PreparedStatement ps = null;
    Connection ct = null;
    ResultSet rs = null;
    String url = "jdbc:sqlserver://localhost:1433;databaseName=NewAdmin";
    String user="sa";  //超级管理员
    String password="sa";  //密码
    try {
        //1.加载驱动
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("加载驱动成功！");
    }catch(Exception e) {
        e.printStackTrace();
        System.out.println("加载驱动失败！");
    }
    try {
        //2.连接
        ct=DriverManager.getConnection( url,user,password);
        System.out.println("连接数据库成功！");
    }catch(Exception e) {
        e.printStackTrace();
        System.out.println("连接数据库失败！");
    }



    /*尝试查询数据库*/
    try{
        Statement stmt = ct.createStatement();
        String sql = "select * from NewsList";
        // 执行数据库查询语句
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String id = rs.getString("Newsid");
            String title = rs.getString("NewsTitle");
            String content = rs.getString("NewsContent");
            String classify = rs.getString("NewsClassify");
            String status = rs.getString("NewsStatus");
            News news=new News();//创建User对象用于保持从数据看查出来的数据
                news.setId(rs.getInt("Newsid"));
                news.setTitle(rs.getString("NewsTitle"));
                news.setContent(rs.getString("NewsContent"));
                news.setClassify(rs.getString("NewsClassify"));
                news.setStatus(rs.getInt("NewsStatus"));
            out.println(news.getTitle());


            /*out.println("id:" + id +"\t"+ "title:" + title +"\t"+"content:" + content+"classify:"+classify+"\t"+"status:"+status+"<br>");*/
        }
        if (rs != null) {
            rs.close();
            rs = null;
        }
        if (stmt != null) {
            stmt.close();
            stmt = null;
        }
        if (ct != null) {
            ct.close();
            ct = null;
        }
    }
    catch (SQLException e) {
        e.printStackTrace();
        System.out.println("数据库连接失败");
    }


%>
<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <td class="one">序号</td>
        <td class="two">新闻标题</td>
        <td class="three">新闻内容</td>
        <td class="four">新闻分类</td>
        <td class="five">新闻状态</td>
        <td class="six">操作</td>
    </tr>

    <c:forEach items="${news}" var="news">
        <tr>${news.id}</tr>
        <tr>${news.title}</tr>
        <tr>${news.content}</tr>
        <tr>${news.classify}</tr>
        <tr>${news.status}</tr>
    </c:forEach>
</table>

</html>
