package tech.bilian.myblog.dto;

import tech.bilian.myblog.pojo.Article;

import java.util.List;

public class ArticleExecution {
    //状态
    private int state;

    //状态标识
    private  String stateInfo;

    //文章数量
    private int count;

    private Article article;

    private List<Article> articleList;

    //文章操作失败时构造器
    public ArticleExecution(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    //文章操作成功且返回为单个article对象时构造器
    public ArticleExecution(int state, String stateInfo, Article article) {
        this.state = state;
        this.stateInfo = stateInfo;
        this.article = article;
    }

    //文章操作成功且返回为多个article对象时构造器
    public ArticleExecution(int state, String stateInfo, int count, List<Article> articleList) {
        this.state = state;
        this.stateInfo = stateInfo;
        this.count = count;
        this.articleList = articleList;
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
