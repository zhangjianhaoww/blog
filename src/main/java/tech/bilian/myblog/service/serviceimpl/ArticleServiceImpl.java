package tech.bilian.myblog.service.serviceimpl;

import tech.bilian.myblog.dao.ArticleDao;
import tech.bilian.myblog.dto.ArticleExecution;
import tech.bilian.myblog.dto.ParentTypeExecution;
import tech.bilian.myblog.pojo.Article;
import tech.bilian.myblog.pojo.ArticleType;
import tech.bilian.myblog.pojo.User;
import tech.bilian.myblog.service.ArticleService;
import tech.bilian.myblog.utils.Image;
import tech.bilian.myblog.utils.ImageUtil;
import tech.bilian.myblog.utils.PathUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Resource
    ArticleDao articleDao;

    /**
     * admin页面初始化时获得文章信息
     *
     * @param article
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @Override
    public ArticleExecution getArticleInitInfo(Article article, int rowIndex, int pageSize) {
        List<Article> articleList = articleDao.getArticleInitInfo(article, rowIndex, pageSize);
        return new ArticleExecution(1, "success", articleList.size(), articleList);
    }

    @Override
    public int getArticleInitInfoCount(Article article) {
        return articleDao.getArticleInitInfoCount(article);
    }

    /**
     * 前端index页面：通过一级目录查询文章基本信息
     *
     * @param article
     * @param rowIndex
     * @param pageSize
     * @return
     */
    @Override
    public ParentTypeExecution getArticleIndexInfoByParentType(Article article, int rowIndex, int pageSize) {
        if(article == null || article.getArticleType() == null || article.getArticleType().getParent() == null
                || article.getArticleType().getParent().getArticleTypeId() == null){
            return new ParentTypeExecution(-1, "文章类别的父类别的id不能为空");
        }
        if(rowIndex < 0 || pageSize < 0){
            return new ParentTypeExecution(-2, "rowIndex或pageSize输入错误");
        }
        //查询符合条件文章数量
        int articleCount = articleDao.queryArticleCountByParentId(article);
        if (articleCount < 0){
            return new ParentTypeExecution(-4, "文章数量查询失败");
        }

        if(rowIndex > articleCount){
            return new ParentTypeExecution(-5, "rowIndex大于实际数量");
        }

        //查询符合条件文章
        List<Article> articleList = articleDao.selectArticleByParentTypeId(article, rowIndex, pageSize);
        if (articleList == null || articleList.size()<0){
            return new ParentTypeExecution(-3, "数据库查询失败");
        }

        //最后返回成功信息
        return new ParentTypeExecution(articleCount, articleList.size(), 1, "查询成功", articleList);
    }

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    @Override
    @Transactional
    public ArticleExecution insertArticle(Article article, Image image, Long userId) {
        if(article == null){
            return new ArticleExecution(-1, "article 不能为空！！！！");
        }
        try{
            article.setArticleLike(0);
            article.setArticleCreateTime(new Date());
            article.setArticleCreateTime(new Date());

            //session TODO
            User user = new User();
            user.setUserId(1L);

            article.setArticleOwner(user);



            int effectNum = articleDao.insertArticle(article);
            if(effectNum <= 0){
                throw new RuntimeException("文章传入数据库失败！！！");
            }else{
                if (image != null){
                    try {
                        addArticleImg(article, image);
                    }catch (Exception e){
                        throw new RuntimeException("文章图片插入失败！！！" + e.getMessage());
                    }
                    effectNum = articleDao.updateArticleImg(article);
                    if(effectNum <= 0){
                        throw new RuntimeException("图片信息插入失败！！！");
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return new ArticleExecution(1, "添加成功！！！");
        // return articleDao.insertArticle(article);
    }

    @Override
    public int queryArticleCount(Article article) {
        int result = articleDao.queryArticleCount(article);
        if(result < 0){

        }else {

        }
        return  result;

    }

    @Override
    public ArticleExecution queryArticleList(Article article, int rowIndex, int pageSize) {
        List<Article> articleList = articleDao.queryArticleList(article, rowIndex, pageSize);
        if(articleList == null){
            return new ArticleExecution(-1, "文章列表查找失败！！！！");
        }
        else{
            return new ArticleExecution(1, "success", articleList.size(), articleList );
        }
    }


    private void addArticleImg(Article article, Image image)  throws Exception{
        String dest = PathUtil.getShopImagePath(article.getArticleOwner().getUserId(), article.getArticleId());
        String articleImgAddr = ImageUtil.generateThumbnail(image, dest);
        article.setArticleImage(articleImgAddr);
    }
}