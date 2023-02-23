package zian.example.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zian.example.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/23/12:01
 * @Description:
 */
public class QueryTest {
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.querySumUser(10);
        System.out.println(result);
    }
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, ?> map = userMapper.queryUserByUserNameToMap("ljzhang");
        System.out.println(map);
    }
    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Map<String , ?>> users =  userMapper.queryUserByAge(18,25);
        System.out.println(users);
    }
    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<Integer,?> map = userMapper.queryUserByAgeToMap(18,23);
        System.out.println(map);
    }
}
