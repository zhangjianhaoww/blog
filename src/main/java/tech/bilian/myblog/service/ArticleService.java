package tech.bilian.myblog.service;

import org.springframework.stereotype.Service;
import tech.bilian.myblog.dto.ArticleExecution;
import tech.bilian.myblog.dto.Execution;
import tech.bilian.myblog.dto.ParentTypeExecution;
import tech.bilian.myblog.pojo.Article;
import tech.bilian.myblog.utils.Image;

import java.io.File;

@Service
public interface ArticleService {

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    Execution<Article> insertArticle(Article article, Image image, Long userId);


    Execution<Article> queryArticleList(Article article, int rowIndex, int pageSize);


    int queryArticleCount(Article article);

    /**
     * admin页面初始化时获得文章信息
     *
     * @param article
     * @param rowIndex
     * @param pageSize
     * @return
     */
    Execution<Article> getArticleInitInfo(Article article, int rowIndex, int pageSize);


    int getArticleInitInfoCount(Article article);

    /**
     * 前端index页面：通过一级目录查询文章基本信息
     * @param article
     * @param rowIndex
     * @param pageSize
     * @return
     */
    ParentTypeExecution getArticleIndexInfoByParentType(Article article, int rowIndex, int pageSize);

    /**
     * 通过文章id查询文章信息
     *
     * @param id
     * @return
     */
    Execution<Article> getArticleById(long id);
}
