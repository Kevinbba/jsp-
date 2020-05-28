package servlet;

import News.News;
import dao.NewsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletViewNews")
public class ServletViewNews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int newsid = Integer.parseInt(request.getParameter("id"));
        NewsDao newsDao = new NewsDao();
        News news = newsDao.selectOneNewsInfo(newsid);

        request.setAttribute("news",news);
        request.getRequestDispatcher("NewAdminEdit.jsp").forward(request,response);
        String userName = request.getParameter("userName");
        request.setAttribute("userName", userName);


       /* request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 设置编码格式为 UTF-8

        String newsTitle = request.getParameter("newsTitle");
        String newsContent = request.getParameter("newsContent");
        String newsClassify = request.getParameter("newsClassify");

        // 前台得到 用户输入数据

        News news = news News();*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
