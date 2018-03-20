package tech.bilian.myblog.pojo;

import java.util.Date;

public class Article{

    private Long articleId;

    //private Integer articleStatus;

    private String articleName;

    private String articleImage;

    private  ArticleType articleType;

    private User articleOwner;

    private String articleDesc;

    private String articleText;

    private Date articleCreateTime;

    private Date articleLastEditTime;

    private Integer articleLike;

    private Integer articlePriority;


    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public User getArticleOwner() {
        return articleOwner;
    }

    public void setArticleOwner(User articleOwner) {
        this.articleOwner = articleOwner;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    public Date getArticleLastEditTime() {
        return articleLastEditTime;
    }

    public void setArticleLastEditTime(Date articleLastEditTime) {
        this.articleLastEditTime = articleLastEditTime;
    }

    public Integer getArticleLike() {
        return articleLike;
    }

    public void setArticleLike(Integer articleLike) {
        this.articleLike = articleLike;
    }

    public Integer getArticlePriority() {
        return articlePriority;
    }

    public void setArticlePriority(Integer articlePriority) {
        this.articlePriority = articlePriority;
    }

//    public Integer getArticleStatus() {
//        return articleStatus;
//    }
//
//    public void setArticleStatus(Integer articleStatus) {
//        this.articleStatus = articleStatus;
//    }
}
