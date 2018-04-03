package tech.bilian.myblog.dao.cache;

import org.junit.Test;
import tech.bilian.myblog.BaseTest;
import tech.bilian.myblog.dao.ArticleDao;
import tech.bilian.myblog.pojo.Article;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class RedisDaoTest extends BaseTest{

    @Resource
    RedisDao redisDao;

    @Resource
    ArticleDao articleDao;

    @Test
    public void getArticle() {

        long id = 5L;

        Article article = redisDao.getArticle(id);
        if(article == null){
            article = articleDao.getArticleById(id);
            if(article != null){
                String result = redisDao.putAtricle(article);
                System.out.println(result);
                article = redisDao.getArticle(id);
                System.out.println(article.getArticleName());
            }
        }

    }

    @Test
    public void putAtricle() {
    }
}