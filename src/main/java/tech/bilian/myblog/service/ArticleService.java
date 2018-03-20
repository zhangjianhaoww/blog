package tech.bilian.myblog.service;

import org.springframework.stereotype.Service;
import tech.bilian.myblog.dto.ArticleExecution;
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
    ArticleExecution insertArticle(Article article, File imageFile, Long userId);


    ArticleExecution queryArticleList(Article article, int rowIndex, int pageSize);


    int queryArticleCount(Article article);

    /**
     * admin页面初始化时获得文章信息
     *
     * @param article
     * @param rowIndex
     * @param pageSize
     * @return
     */
    ArticleExecution getArticleInitInfo(Article article, int rowIndex, int pageSize);


    int getArticleInitInfoCount(Article article);
}
