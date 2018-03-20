package tech.bilian.myblog.service;

import tech.bilian.myblog.dto.UserExecution;
import tech.bilian.myblog.pojo.User;

public interface UserService {

    /**
     * 查询用户信息
     *
     * @param user
     * @return
     */
    UserExecution queryUser(User user);

}
