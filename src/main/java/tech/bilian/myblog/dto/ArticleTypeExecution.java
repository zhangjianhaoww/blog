package tech.bilian.myblog.dto;

import tech.bilian.myblog.pojo.ArticleType;

import java.util.List;

public class ArticleTypeExecution {
    //状态
    private int state;

    //状态标识
    private  String stateInfo;

    //文章数量
    private int count;

    private ArticleType articleType;

    private List<ArticleType> articleTypeList;

    public ArticleTypeExecution(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public ArticleTypeExecution(int state, String stateInfo, ArticleType articleType) {
        this.state = state;
        this.stateInfo = stateInfo;
        this.articleType = articleType;
    }

    public ArticleTypeExecution(int state, String stateInfo, int count, List<ArticleType> articleTypeList) {
        this.state = state;
        this.stateInfo = stateInfo;
        this.count = count;
        this.articleTypeList = articleTypeList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public List<ArticleType> getArticleTypeList() {
        return articleTypeList;
    }

    public void setArticleTypeList(List<ArticleType> articleTypeList) {
        this.articleTypeList = articleTypeList;
    }
}
