package tech.bilian.myblog.service.serviceimpl;

import org.junit.Test;
import tech.bilian.myblog.BaseTest;
import tech.bilian.myblog.dto.ArticleExecution;
import tech.bilian.myblog.dto.ParentTypeExecution;
import tech.bilian.myblog.pojo.Article;
import tech.bilian.myblog.pojo.ArticleType;
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
    public void getArticleIndexInfoByParentTypeTest() {
        Article article = new Article();
        ArticleType articleType = new ArticleType();
        ArticleType parentType = new ArticleType();
        parentType.setArticleTypeId(1);
        articleType.setParent(parentType);
        article.setArticleType(articleType);
        ParentTypeExecution execution = articleService.getArticleIndexInfoByParentType(article, 0 , 10);
        System.out.println("count:" + execution.getCount());
        System.out.println("pageSize:" + execution.getPageSize());
    }

    @Test
    public void queryArticleCount() {
    }

    @Test
    public void queryArticleList() {
    }
}