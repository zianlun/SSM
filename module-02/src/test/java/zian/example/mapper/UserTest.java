package zian.example.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zian.example.pojo.User;
import zian.example.utils.SqlSessionUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/22/20:44
 * @Description:
 */
public class UserTest {
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<User> users = userMapper.selectUserAge();
        for(User user : users) {
            System.out.println(user);
        }

    }
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=userMapper.selectUserById(1);
        System.out.println(user);
    }

}
