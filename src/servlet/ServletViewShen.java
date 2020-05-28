package servlet;

import News.News;
import dao.NewsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletViewShen")
public class ServletViewShen extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int newsid = Integer.parseInt(request.getParameter("id"));
        NewsDao newsDao = new NewsDao();
        News news = newsDao.selectOneNewsInfo(newsid);

        request.setAttribute("news",news);

        request.getRequestDispatcher("NewAdminConShen.jsp").forward(request,response);
        String userName = request.getParameter("userName");
        request.setAttribute("userName", userName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
