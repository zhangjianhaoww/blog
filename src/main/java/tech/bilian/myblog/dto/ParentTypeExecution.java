package tech.bilian.myblog.dto;

import tech.bilian.myblog.pojo.Article;

import java.util.List;

/**
 * 对通过一级目录查询文章返回类型的封装
 */
public class ParentTypeExecution {
    //符合文章的总数
    private int count;

    //本次返回的文章总数
    private int pageSize;

    //返回状态
    private int status;

    //状态的说明
    private String statusInfo;

    //返回的文章列表
    private List<Article> articleList;

    //查询失败时返回类型
    public ParentTypeExecution(int status, String statusInfo) {
        this.status = status;
        this.statusInfo = statusInfo;
    }

    //查询成功返回类型
    public ParentTypeExecution(int count, int pageSize, int status, String statusInfo, List<Article> articleList) {
        this.count = count;
        this.pageSize = pageSize;
        this.status = status;
        this.statusInfo = statusInfo;
        this.articleList = articleList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
