package zian.example.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zian.example.Utils.SqlSessionUtil;
import zian.example.pojo.Employee;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/24/22:14
 * @Description:
 */
public class CacheTest {
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper cache1 = sqlSession.getMapper(CacheMapper.class);
        Employee emp1 = cache1.queryEmployee(1);
        System.out.println(emp1);
        CacheMapper cache2 = sqlSession.getMapper(CacheMapper.class);
        Employee emp2 = cache2.queryEmployee(2);
        System.out.println(emp2);
        System.out.println(cache1.queryEmployee(1));
    }

    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);
        Employee employee = new Employee(null,"ljzhang",10,"女");
        int result = cacheMapper.updateEmployee(7, employee);
    }
}
