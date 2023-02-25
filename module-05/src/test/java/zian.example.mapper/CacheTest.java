package zian.example.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import zian.example.Utils.SqlSessionUtil;
import zian.example.pojo.Employee;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/24/22:14
 * @Description:
 */
public class CacheTest {
    /***
    * @Description:一级缓存
    * @Author: ljzhang
    * @Date: 2023/2/25
    */
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper cache1 = sqlSession.getMapper(CacheMapper.class);
        Employee emp1 = cache1.queryEmployee(1);
        System.out.println(emp1);
        Employee employee = new Employee(null,"zian",101,"男");
        CacheMapper cache2 = sqlSession.getMapper(CacheMapper.class);
        int result = cache2.updateEmployee(2,employee);
        System.out.println(cache1.queryEmployee(1));
    }
    /***
    * @Description:二级缓存
    * @Author: ljzhang
    * @Date: 2023/2/25
    */
    @Test
    public void test2() throws IOException {
        InputStream is =  Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper cacheMapper1 = sqlSession1.getMapper(CacheMapper.class);
        CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
        System.out.println(cacheMapper1.queryEmployee(1));
        sqlSession1.close();
        System.out.println(cacheMapper2.queryEmployee(1));
    }
}
