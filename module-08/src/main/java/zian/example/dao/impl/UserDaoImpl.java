package zian.example.dao.impl;

import org.springframework.stereotype.Repository;
import zian.example.dao.UserDao;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/26/23:06
 * @Description:
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("保存");
    }
}
