package tech.bilian.myblog.service;

import tech.bilian.myblog.dao.split.DataSource;
import tech.bilian.myblog.dto.ArticleTypeExecution;
import tech.bilian.myblog.dto.Execution;
import tech.bilian.myblog.pojo.ArticleType;

public interface ArticleTypeService {
    /**
     * 获取种类
     *
     * @param articleType
     * @return
     */
    @DataSource("slave")
    Execution<ArticleType> queryArticleType(ArticleType articleType);
}
