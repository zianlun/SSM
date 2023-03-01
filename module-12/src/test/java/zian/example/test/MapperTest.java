package zian.example.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zian.example.Utils.SqlSessionUtil;
import zian.example.mapper.BookMapper;
import zian.example.mapper.UserMapper;
import zian.example.pojo.Book;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/03/01/21:15
 * @Description:
 */
public class MapperTest {
    private SqlSession  sqlSession = SqlSessionUtil.getSqlSession();
    @Test
    public void test1(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer result = userMapper.updateBalance(1,(double)100);
        System.out.println(result);
    }
    @Test
    public void tes2(){
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Integer result = bookMapper.updateStack(1);
        System.out.println(result);
    }
    @Test
    public void test3(){
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Double price = bookMapper.queryBookPrice(1);
        System.out.println(price);
    }

    @Test
    public void test4(){
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Map<Integer, ?> books = bookMapper.queryAllBook();
        System.out.println(books);
    }
}
