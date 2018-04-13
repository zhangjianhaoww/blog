package tech.bilian.myblog.service.serviceimpl;

import org.junit.Test;
import tech.bilian.myblog.BaseTest;
import tech.bilian.myblog.dao.UserDao;
import tech.bilian.myblog.dto.Execution;
import tech.bilian.myblog.dto.UserExecution;
import tech.bilian.myblog.pojo.User;
import tech.bilian.myblog.service.UserService;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class UserServiceImplTest extends BaseTest{

    @Resource
    UserService userService;
    @Test
    public void queryUserTest() {
        User user = new User();
        user.setUserName("admin");
        Execution<User> execution = userService.queryUser(user);
        System.out.println(execution.getModel().getUserPassword());


    }

    @Test
    public void selectUserDetailsByIdTest(){
        Execution<User> execution = userService.selectUserDetailsById(1);
        System.out.println(execution.getModel().getUserName());
    }
}