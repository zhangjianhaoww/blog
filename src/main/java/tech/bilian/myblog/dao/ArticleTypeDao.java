package tech.bilian.myblog.dao;

import org.apache.ibatis.annotations.Param;
import tech.bilian.myblog.pojo.ArticleType;

import java.util.List;

public interface ArticleTypeDao {

    List<ArticleType> queryArticleType(@Param("articleType") ArticleType articleType);


    ArticleType selectArticleTypeById(int id);

    ArticleType selectFullArticleTypeById(int id);
}
