package servlet;

import User.Users;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserloginServlet")
public class UserloginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");

        UserDao userDao = new UserDao();
        Users user = userDao.judgeUserPassword(userName, userPassword);

        String message = "用户名或密码错误~！";
        if (user == null) {
            // 如果用户不存在，重新登录
            request.setAttribute("message", message);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
         }else {
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("/NewsListServlet").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
