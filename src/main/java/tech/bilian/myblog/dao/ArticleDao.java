package tech.bilian.myblog.dao;

import tech.bilian.myblog.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {
    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    int insertArticle (Article article);

    /**
     * 查询符合条件的文章
     *
     * @param article
     * @return
     */
    List<Article> queryArticleList (@Param("article") Article article , @Param("rowIndex")int rowIndex, @Param("pageSize")int pageSize);

    /**
     * 添加文章对应图片
     *
     * @param article
     * @return
     */
    int updateArticleImg (Article article);

    /**
     * 获取文章数量
     * @param article
     * @return
     */
    int queryArticleCount(@Param("article1") Article article);

    /**
     * 获取文章的基本信息
     *
     * @param article
     * @return
     */

    List<Article> getArticleShortInfo(@Param("article") Article article, @Param("rowIndex")int rowIndex, @Param("pageSize")int pageSize);


    /**
     * admin端获取文章列表
     *
     * @param article
     * @param rowIndex
     * @param pageSize
     * @return
     */
    List<Article> getArticleInitInfo(@Param("article") Article article, @Param("rowIndex")int rowIndex, @Param("pageSize")int pageSize);


    int getArticleInitInfoCount(@Param("article") Article article);
}
