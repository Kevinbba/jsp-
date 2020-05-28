package servlet;

import News.News;
import dao.NewsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String newsTitle = request.getParameter("newsTitle");
        String newsContent = request.getParameter("newsContent");
        String newsClassify = request.getParameter("newsClassify");

        News news = new News();
        news.setTitle(newsTitle);
        news.setContent(newsContent);
        news.setClassify(newsClassify);

        NewsDao newsDao = new NewsDao();
        // 实例化一个数据库操作对象
        newsDao.insertUser(news);
        // 调用增加用户方法
        request.getRequestDispatcher("NewsListServlet").forward(request,response);
        String userName = request.getParameter("userName");
        request.setAttribute("userName", userName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
