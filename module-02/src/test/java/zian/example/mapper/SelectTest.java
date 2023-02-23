package zian.example.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zian.example.pojo.User;
import zian.example.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/23/13:31
 * @Description:
 */
public class SelectTest {
    /***
    * @Description:模糊查询
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users =  selectMapper.queryUserLike("ad");
        System.out.println(users);
    }
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        selectMapper.deleteMoreUser("34,35,36");
    }
    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, ?> map = selectMapper.queryAllUserByTable("user");
        System.out.println(map);
    }
    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        User user = new User(null, "ljzhang", "312abc",23,"男","313@qq.com");
        int result  = selectMapper.insertUser(user);
        System.out.println(user);
    }
}
