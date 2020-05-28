package servlet;

import dao.NewsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletFailPassShen")
public class ServletFailPassShen extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int newsid = Integer.parseInt(request.getParameter("id"));
        NewsDao newsDao = new NewsDao();
        newsDao.failpassOneNews(newsid);


        request.getRequestDispatcher("ServletNewsShenhe").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
