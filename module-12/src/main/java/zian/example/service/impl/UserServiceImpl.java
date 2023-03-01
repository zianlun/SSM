package zian.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zian.example.mapper.UserMapper;
import zian.example.service.UserService;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/28/16:10
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userDao;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserMapper userDao) {
        this.userDao = userDao;
    }

    public UserMapper getUserDao() {
        return userDao;
    }

    public void setUserDao(UserMapper userDao) {
        this.userDao = userDao;
    }
}
