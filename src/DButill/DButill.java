package DButill;

import News.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DButill {
    public static Connection getConnection() throws SQLException,ClassNotFoundException {

            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driverName);
            String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=NewAdmin";
            String userName = "sa";
            String userPwd = "sa";
            Connection conn = DriverManager.getConnection(dbURL, userName, userPwd);

            return conn;
        }
        //关闭数据库连接，释放资源
        public static void release(PreparedStatement prestmt, Connection conn,

                                   ResultSet rs) {

            if (prestmt != null) {

                try {

                    prestmt.close();

                } catch (SQLException e) {

                    e.printStackTrace();

                }

                prestmt = null;

            }

            if (conn != null) {

                try {

                    conn.close();

                } catch (SQLException e) {

                    e.printStackTrace();

                }

                conn = null;

            }

            if (rs != null) {

                try {

                    rs.close();

                } catch (SQLException e) {

                    e.printStackTrace();

                }

                rs = null;

            }

        }


    }





