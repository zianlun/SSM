package zian.example.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zian.example.pojo.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/28/15:19
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JDBCTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1(){
        String sql = "insert into user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql,"ljzhang","123456",18,"男","3131939824@qq.com");
    }
    @Test
    public void test2(){
        String sql = "delete from USER where email=?";
        jdbcTemplate.update(sql,"3131939824@qq.com");
    }

    @Test
    public void test3(){
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
        users.forEach(System.out::println);
    }
}
