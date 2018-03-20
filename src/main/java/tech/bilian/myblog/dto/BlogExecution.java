package tech.bilian.myblog.dto;

import java.util.List;

public class BlogExecution<T> {
    //状态
    private int state;

    //状态标识
    private  String stateInfo;

    //文章数量
    private int count;

    private T data;

    private List<T> dataList;
}
