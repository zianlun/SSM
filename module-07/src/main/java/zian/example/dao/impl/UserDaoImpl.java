package zian.example.dao.impl;

import zian.example.dao.UserDao;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/26/19:49
 * @Description:
 */
public class UserDaoImpl implements UserDao {


    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
