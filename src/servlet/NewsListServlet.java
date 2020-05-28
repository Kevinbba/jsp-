package servlet;

import News.News;
import service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewsListServlet")
public class NewsListServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
