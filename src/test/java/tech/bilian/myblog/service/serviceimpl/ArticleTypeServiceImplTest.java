package tech.bilian.myblog.service.serviceimpl;

import org.junit.Test;
import tech.bilian.myblog.BaseTest;
import tech.bilian.myblog.dao.ArticleTypeDao;
import tech.bilian.myblog.dto.ArticleTypeExecution;
import tech.bilian.myblog.dto.Execution;
import tech.bilian.myblog.pojo.ArticleType;
import tech.bilian.myblog.service.ArticleTypeService;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class ArticleTypeServiceImplTest extends BaseTest{

    @Resource
    ArticleTypeService articleTypeService;

    @Test
    public void queryArticleTypeTest() {
        Execution<ArticleType> articleTypeExecution = articleTypeService.queryArticleType(null);
        System.out.println(articleTypeExecution.getCount());
    }
}