package tech.bilian.myblog.pojo;

import java.util.Date;

public class ArticleType {
    private Integer articleTypeId;

    private String articleTypeName;

    private String articleTypeDesc;

    private Integer priority;

    private ArticleType parent;

    private Date createTime;

    private Date lastEditTime;



    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public String getArticleTypeDesc() {
        return articleTypeDesc;
    }

    public void setArticleTypeDesc(String articleTypeDesc) {
        this.articleTypeDesc = articleTypeDesc;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public ArticleType getParent() {
        return parent;
    }

    public void setParent(ArticleType parent) {
        this.parent = parent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
