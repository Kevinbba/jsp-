package servlet;

import service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletNewsShenhe")
public class ServletNewsShenhe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        NewsService newsService=new NewsService();//创建UserService对象，

        List list=newsService.getListShenhe();

        request.setAttribute("list", list);

        request.getRequestDispatcher("NewAdminShenhe.jsp").forward(request, response);//跳转到success.jsp页面
        String userName = request.getParameter("userName");
        request.setAttribute("userName", userName);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
