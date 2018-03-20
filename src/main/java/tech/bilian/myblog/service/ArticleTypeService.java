package tech.bilian.myblog.service;

import tech.bilian.myblog.dto.ArticleTypeExecution;
import tech.bilian.myblog.pojo.ArticleType;

public interface ArticleTypeService {
    /**
     * 获取种类
     *
     * @param articleType
     * @return
     */
    ArticleTypeExecution queryArticleType(ArticleType articleType);
}
