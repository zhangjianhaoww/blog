package tech.bilian.myblog.service.serviceimpl;

import org.springframework.stereotype.Service;
import tech.bilian.myblog.dao.ArticleTypeDao;
import tech.bilian.myblog.dto.ArticleTypeExecution;
import tech.bilian.myblog.pojo.ArticleType;
import tech.bilian.myblog.service.ArticleTypeService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Resource
    ArticleTypeDao articleTypeDao;

    /**
     * 获取种类
     *
     * @param articleType
     * @return
     */
    @Override
    public ArticleTypeExecution queryArticleType(ArticleType articleType) {
        List<ArticleType> articleTypeList = articleTypeDao.queryArticleType(articleType);
        if(articleTypeList.size() < 0){
            return new ArticleTypeExecution(-1, "操作数据库失败！！！");
        }
        if(articleTypeList.size() == 0){
            return new ArticleTypeExecution(0, "查询数据为空！！！");
        }
        return new ArticleTypeExecution(1, "操作成功！！！", articleTypeList.size(), articleTypeList);
    }
}
