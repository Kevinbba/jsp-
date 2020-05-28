package dao;

import DButill.DButill;
import News.News;
import User.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public Users judgeUserPassword(String userName, String userPassword) {
        PreparedStatement prestmt = null;
        Connection conn = null;
        ResultSet rs = null;
        Users user = null;

        try {
            conn = DButill.getConnection();
            String sql = "SELECT * FROM Users WHERE username = '"
                    + userName + "' AND password= '" + userPassword + "'";
            prestmt = conn.prepareStatement(sql);
            rs = prestmt.executeQuery();

            while (rs.next()) {
                user = new Users();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButill.release(prestmt, conn, rs);
        }
        return user;
    }
}
