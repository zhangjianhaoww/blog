package tech.bilian.myblog.dao;

import org.junit.Test;
import tech.bilian.myblog.BaseTest;
import tech.bilian.myblog.pojo.ArticleType;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

public class ArticleTypeDaoTest extends BaseTest{

    @Resource
    ArticleTypeDao articleTypeDao;

    @Test
    public void queryArticleTypeTest() {
        List<ArticleType> articleTypes = articleTypeDao.queryArticleType(null);
        for(ArticleType articleType : articleTypes){
            System.out.println(articleType.getArticleTypeName());
        }
    }


    @Test
    public void selectFullArticleTypeByIdTest() {
       ArticleType articleType = articleTypeDao.selectFullArticleTypeById(4);
       System.out.println(articleType.getArticleTypeName());
       System.out.println(articleType.getParent().getArticleTypeName());
    }
}