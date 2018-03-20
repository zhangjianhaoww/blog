package tech.bilian.myblog.service.serviceimpl;

import org.springframework.stereotype.Service;
import tech.bilian.myblog.dao.UserDao;
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
    public UserExecution queryUser(User user) {
        User result = userDao.queryUser(user);
        if(result == null){
            return new UserExecution(0, "用户不存在");
        }
        return new UserExecution(1, "查询成功", result);
    }
}
