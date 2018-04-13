package tech.bilian.myblog.service;

import tech.bilian.myblog.dao.split.DataSource;
import tech.bilian.myblog.dto.Execution;
import tech.bilian.myblog.dto.UserExecution;
import tech.bilian.myblog.pojo.User;

public interface UserService {

    /**
     * 查询用户信息
     *
     * @param user
     * @return
     */
    @DataSource("slave")
    Execution<User> queryUser(User user);

    /**
     * 根据用户id查找用户详细信息
     *
     * @param id
     * @return
     */
    @DataSource("slave")
    Execution<User> selectUserDetailsById(long id);

}
