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

    /**
     * 根据用户id查找用户详细信息
     *
     * @param id
     * @return
     */
    UserExecution selectUserDetailsById(long id);

}
