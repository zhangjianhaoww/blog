package tech.bilian.myblog.service.serviceimpl;

import tech.bilian.myblog.dao.ArticleDao;
import tech.bilian.myblog.dto.ArticleExecution;
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
     * 添加文章
     *
     * @param article
     * @return
     */
    @Override
    @Transactional
    public ArticleExecution insertArticle(Article article, File imageFile, Long userId) {
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
                if (imageFile != null){
                    try {
                        addArticleImg(article, imageFile);
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


    private void addArticleImg(Article article, File imageFile)  throws Exception{
        String dest = PathUtil.getShopImagePath(article.getArticleOwner().getUserId(), article.getArticleId());
        String articleImgAddr = ImageUtil.generateThumbnail(imageFile, dest);
        article.setArticleImage(articleImgAddr);
    }
}