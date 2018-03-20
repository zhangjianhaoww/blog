package tech.bilian.myblog.dto;

import tech.bilian.myblog.pojo.User;

import java.util.List;

public class UserExecution {
    //状态
    private int state;

    //状态标识
    private  String stateInfo;

    //文章数量
    private int count;

    private List<User> userList;

    private User user;

    public UserExecution(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public UserExecution(int state, String stateInfo, int count, List<User> userList) {
        this.state = state;
        this.stateInfo = stateInfo;
        this.count = count;
        this.userList = userList;
    }

    public UserExecution(int state, String stateInfo, User user) {
        this.state = state;
        this.stateInfo = stateInfo;
        this.user = user;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
