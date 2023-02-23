package zian.example.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zian.example.pojo.User;
import zian.example.utils.SqlSessionUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/22/22:15
 * @Description:
 */
public class ParamTest {
    @Test
    public void  test1(){
        SqlSession sqlSession =  SqlSessionUtil.getSqlSession();
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        User user =  userMapper.selectUserByName("ljzhang");
        System.out.println(user);
    }
    @Test
    public void test2(){
        SqlSession sqlSession =  SqlSessionUtil.getSqlSession();
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        User user  = userMapper.verifyLogin("ljzhang","1256735");
        System.out.println(user);
    }
    @Test
    public void test3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("age","17");
        map.put("gender","男");
        ArrayList<User> users = userMapper.queryUserByAgeAndGender(map);
        for(User user: users){
            System.out.println(user);
        }
    }
    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"zian","123454",11,"女","313@qq.com");
        userMapper.insertUser(user);
    }
    @Test
    public void test5(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserByIdParam(30);
        System.out.println(user);
    }
    @Test
    public void test6(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result =  userMapper.updatePassWord("123456");
        System.out.println(result);
    }
}
