package tech.bilian.myblog.dao;

import org.junit.Test;
import tech.bilian.myblog.BaseTest;
import tech.bilian.myblog.pojo.User;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

public class UserDaoTest extends BaseTest{

    @Resource
    UserDao userDao;

    @Test
    public void quseryUserTest() {
        User TestUser = new User();
        TestUser.setUserId(1L);
        User user = userDao.queryUser(TestUser);
        System.out.println(user.getUserName());
    }

    @Test
    public void selectUserById()
    {
        User user = userDao.selectUserById(1);
        System.out.println(user.getUserName());
    }
}