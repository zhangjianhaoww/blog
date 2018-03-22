package tech.bilian.myblog.dao;

import org.junit.Test;
import tech.bilian.myblog.BaseTest;
import tech.bilian.myblog.pojo.Article;
import tech.bilian.myblog.pojo.ArticleType;
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
        ArticleType articleType = new ArticleType();
        articleType.setArticleTypeId(4);
        article.setArticleType(articleType);
        //User user = new User();
        //user.setUserId(1L);
       // article.setArticleOwner(user);
        List<Article> articles = articleDao.queryArticleList(article, 0, 10);
        System.out.println(articles.size());
    }

    @Test
    public void getArticleInitInfoTest(){
        Article article = new Article();

        User user = new User();
        user.setUserId(1L);
        article.setArticleOwner(user);
        List<Article> articles = articleDao.getArticleInitInfo(article, 0, 10);
        for(Article article1 : articles){
            System.out.println(article1.getArticleOwner().getUserName());
        }
    }

    @Test
    public void queryArticleList1Test(){
        Article article = new Article();
        article.setArticleId(5L);
        List<Article> articles = articleDao.queryArticleList1(article, 0, 10);
        assertEquals(1, articles.size());
        System.out.println(articles.get(0).getArticleType().getParent().getArticleTypeName());

    }

    @Test
    public void selectArticleByParentTypeIdTest(){
        Article article = new Article();
        ArticleType articleType = new ArticleType();
        ArticleType parentType = new ArticleType();
        parentType.setArticleTypeId(1);
        articleType.setParent(parentType);
        article.setArticleType(articleType);
        List<Article> articles = articleDao.selectArticleByParentTypeId(article, 0, 10);
        System.out.println(articles.size());
    }

    @Test
    public void queryArticleCountTest(){
        Article article = new Article();
        ArticleType articleType = new ArticleType();
        articleType.setArticleTypeId(3);
        int count = articleDao.queryArticleCount(article);
        System.out.println(count);
    }
    @Test
    public void queryArticleCountByParentIdTest(){
        Article article = new Article();
        ArticleType articleType = new ArticleType();
        ArticleType parentType = new ArticleType();
        parentType.setArticleTypeId(1);
        articleType.setParent(parentType);
        article.setArticleType(articleType);
        int result = articleDao.queryArticleCountByParentId(article);
        System.out.println(result);
    }
}