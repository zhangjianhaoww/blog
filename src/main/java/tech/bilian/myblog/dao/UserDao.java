package tech.bilian.myblog.dao;

import org.apache.ibatis.annotations.Param;
import tech.bilian.myblog.pojo.User;

public interface UserDao {

    User queryUser(@Param("user") User user);

    User selectUserById(long id);

    User selectUserDetailsById(long id);
}
