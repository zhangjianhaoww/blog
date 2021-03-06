package tech.bilian.myblog.service.serviceimpl;

import org.springframework.stereotype.Service;
import tech.bilian.myblog.dao.UserDao;
import tech.bilian.myblog.dto.Execution;
import tech.bilian.myblog.dto.UserExecution;
import tech.bilian.myblog.pojo.User;
import tech.bilian.myblog.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    UserDao userDao;

    /**
     * 查询用户信息
     *
     * @param user
     * @return
     */
    @Override
    public Execution<User> queryUser(User user) {
        User result = userDao.queryUser(user);
        if(result == null){
            return new Execution<User>(0, "用户不存在");
        }
        return new Execution<User>(1, "查询成功", result);
    }

    /**
     * 根据用户id查找用户详细信息
     *
     * @param id
     * @return
     */
    @Override
    public Execution<User> selectUserDetailsById(long id) {
        User result = userDao.selectUserDetailsById(id);
        if(result == null){
            return new Execution<User>(0, "用户不存在");
        }
        return new Execution<User>(1, "查询成功", result);
    }
}
