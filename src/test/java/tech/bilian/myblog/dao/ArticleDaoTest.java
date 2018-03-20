package tech.bilian.myblog.dao;

import org.junit.Test;
import tech.bilian.myblog.BaseTest;
import tech.bilian.myblog.pojo.Article;
import tech.bilian.myblog.pojo.User;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

public class ArticleDaoTest extends BaseTest {

    @Resource
    ArticleDao articleDao;

    @Test
    public void queryArticleListTest(){
        Article article = new Article();
        article.setArticleId(1L);
        List<Article> articles = articleDao.getArticleShortInfo(article, 0, 10);
        assertEquals(1, articles.size());
    }

    @Test
    public void getArticleInitInfoTest(){
        Article article = new Article();

        User user = new User();
        user.setUserId(1L);
        article.setArticleOwner(user);
        List<Article> articles = articleDao.getArticleInitInfo(article, 0, 10);
        for(Article article1 : articles){
            System.out.println(article1.getArticleId());
        }
    }
}