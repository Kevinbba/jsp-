package servlet;

import News.News;
import dao.NewsDao;
import service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletEditNews")
public class ServletEditNews extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        int Id = Integer.parseInt(request.getParameter("Id"));
        String newsTitle = request.getParameter("newsTitle");
        String newsContent = request.getParameter("newsContent");
        String newsClassify = request.getParameter("newsClassify");

        //将前台得到的数据存进News
        News news = new News();
        news.setId(Id);
        news.setTitle(newsTitle);
        news.setContent(newsContent);
        news.setClassify(newsClassify);


        //调用dao层方法执行数据库语句
        NewsDao newsDao = new NewsDao();
        newsDao.updateNews(news);
        response.setContentType("text/html;charset=UTF-8");

        NewsService newsService=new NewsService();//创建UserService对象，
        List list=newsService.getListAll();
        if (list != null) {
            request.setAttribute("list", list);
        /*HttpSession session = request.getSession();
        session.setAttribute("list",list);*/

            request.getRequestDispatcher("NewAdminList.jsp").forward(request, response);//跳转到success.jsp页面
        }
        else {
            System.out.println("list为空");
        }
        String userName = request.getParameter("userName");
        request.setAttribute("userName", userName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
