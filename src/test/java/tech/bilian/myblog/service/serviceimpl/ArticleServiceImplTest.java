package tech.bilian.myblog.service.serviceimpl;

import org.junit.Test;
import tech.bilian.myblog.BaseTest;
import tech.bilian.myblog.dto.ArticleExecution;
import tech.bilian.myblog.pojo.Article;
import tech.bilian.myblog.pojo.User;
import tech.bilian.myblog.service.ArticleService;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class ArticleServiceImplTest extends BaseTest{

    @Resource
    ArticleService articleService;

    @Test
    public void getArticleInitInfo() {
        Article article = new Article();
        User user = new User();
        user.setUserId(1L);
        article.setArticleOwner(user);
        ArticleExecution articleExecution = articleService.getArticleInitInfo(article, 0, 10);
        System.out.println(articleExecution.getCount());
    }

    @Test
    public void insertArticle() {
    }

    @Test
    public void queryArticleCount() {
    }

    @Test
    public void queryArticleList() {
    }
}