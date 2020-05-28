package service;

import News.News;
import dao.NewsDao;

import java.util.List;

public class NewsService {
    public List<News> getListAll(){

        NewsDao newsDao = new NewsDao();
        List list = newsDao.getListAll();
        if (list != null) {
            return list;
        }
        else {
            return null;
        }
    }
    public List<News> getListShenhe(){

        NewsDao newsDao = new NewsDao();
        List list = newsDao.getListShenhe();
        return list;

    }
}
