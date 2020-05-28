package dao;

import DButill.DButill;
import News.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class NewsDao {

    //查找所有新闻

    public List<News> getListAll() {
        PreparedStatement prestmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<News> list = new ArrayList<News>();//创建list集合，用于保持User对象

        try {
            conn = DButill.getConnection();
            String sql = "select * from NewsList";
            prestmt = conn.prepareStatement(sql);
            rs = prestmt.executeQuery();

            while (rs.next()) {
                News news = new News();//创建User对象用于保持从数据看查出来的数据
                news.setId(rs.getInt("Newsid"));
                news.setTitle(rs.getString("NewsTitle"));
                news.setContent(rs.getString("NewsContent"));
                news.setClassify(rs.getString("NewsClassify"));
                news.setStatus(rs.getString("NewsStatus"));
                list.add(news);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButill.release(prestmt, conn, rs);
        }
        return null;


    }

    //查找一个新闻id
    public News selectOneNewsInfo(int newsid) {
        PreparedStatement prestmt = null;
        Connection conn = null;
        ResultSet rs = null;
        News news = null;
        List<News> list = new ArrayList<News>();//创建list集合，用于保持User对象

        try {
            conn = DButill.getConnection();
            String sql = "select * from NewsList where Newsid = " + newsid;
            prestmt = conn.prepareStatement(sql);
            rs = prestmt.executeQuery();

            while (rs.next()) {
                news = new News();//创建User对象用于保持从数据看查出来的数据
                news.setId(rs.getInt("Newsid"));
                news.setTitle(rs.getString("NewsTitle"));
                news.setContent(rs.getString("NewsContent"));
                news.setClassify(rs.getString("NewsClassify"));
                news.setStatus(rs.getString("NewsStatus"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButill.release(prestmt, conn, rs);
        }
        return news;
    }


    //编辑新闻
    public void updateNews(News news) {
        PreparedStatement prestmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = DButill.getConnection();
            String sql = "UPDATE  NewsList SET NewsTitle= '"
                    + news.getTitle() + "', NewsContent= '"
                    + news.getContent() + "', NewsClassify= '"
                    + news.getClassify() + "' WHERE Newsid= " + news.getId();
            prestmt = conn.prepareStatement(sql);
            System.out.println(sql);
            prestmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButill.release(prestmt, conn, rs);
        }
    }

    //获取最大id值
    public int getMaxId(){
        int index = 0;
        PreparedStatement prestmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DButill.getConnection();
            String sql = "select max(Newsid) as id from NewsList";
            prestmt = conn.prepareStatement(sql);
            rs = prestmt.executeQuery();
            if(rs.next()){
                index = rs.getInt("id") + 1;
            }
            else {
                index = 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButill.release(prestmt, conn, rs);
        }
        return index;
    }

    //添加用户
    public void insertUser(News news) {
        PreparedStatement prestmt = null;
        Connection conn = null;
        ResultSet rs = null;
        int newsMaxId = getMaxId();
        try {
            conn = DButill.getConnection();
            String sql = "INSERT INTO NewsList (Newsid,NewsTitle,NewsContent,NewsClassify,NewsStatus)VALUES('"
                    + newsMaxId
                    + "','"
                    + news.getTitle()
                    + "','"
                    + news.getContent()
                    + "','"
                    + news.getClassify()
                    + "','"
                    + "审核中"
                    + "')";
            prestmt = conn.prepareStatement(sql);
            System.out.println(newsMaxId);
            prestmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButill.release(prestmt, conn, rs);
        }
    }

    //删除单个新闻
    public void deteleOneNews(int newsid){
        PreparedStatement prestmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DButill.getConnection();
            String sql = "delete from NewsList where Newsid = "+ newsid;
            prestmt = conn.prepareStatement(sql);
            prestmt.executeUpdate();
            System.out.println(newsid);
            autoIncrement(newsid);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButill.release(prestmt, conn, rs);
        }
    }

    //删除中间行前面新闻id自减1
    public void autoIncrement(int newsid){
        PreparedStatement prestmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DButill.getConnection();
            String sql = "update NewsList set Newsid = Newsid-1 where Newsid >"+ newsid;
            prestmt = conn.prepareStatement(sql);
            prestmt.executeUpdate();
            System.out.println(sql);
            System.out.println(newsid);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButill.release(prestmt, conn, rs);
        }
    }


    //把所有审核中的新闻都打印出来
    public List<News> getListShenhe(){
        PreparedStatement prestmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<News> list = new ArrayList<News>();//创建list集合，用于保持User对象

        try {
            conn = DButill.getConnection();
            String sql = "select * from NewsList where NewsStatus = '审核中'";
            prestmt = conn.prepareStatement(sql);
            rs = prestmt.executeQuery();
            System.out.println(sql);
            while (rs.next()) {
                News news = new News();//创建User对象用于保持从数据看查出来的数据
                news.setId(rs.getInt("Newsid"));
                news.setTitle(rs.getString("NewsTitle"));
                news.setContent(rs.getString("NewsContent"));
                news.setClassify(rs.getString("NewsClassify"));
                news.setStatus(rs.getString("NewsStatus"));
                list.add(news);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButill.release(prestmt, conn, rs);
        }
        return list;
    }

    //审核通过一条新闻
    public void passOneNews(int newsid){
        PreparedStatement prestmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DButill.getConnection();
            String sql = "UPDATE  NewsList SET NewsStatus= '通过' where Newsid =  "+ newsid;
            prestmt = conn.prepareStatement(sql);
            prestmt.executeUpdate();
            System.out.println(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButill.release(prestmt, conn, rs);
        }
    }

    //审核不通过一条新闻

    public void failpassOneNews(int newsid){
        PreparedStatement prestmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DButill.getConnection();
            String sql = "UPDATE  NewsList SET NewsStatus= '不通过' where Newsid =  "+ newsid;
            prestmt = conn.prepareStatement(sql);
            prestmt.executeUpdate();
            System.out.println(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButill.release(prestmt, conn, rs);
        }
    }

}

