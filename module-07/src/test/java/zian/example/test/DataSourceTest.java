package zian.example.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/26/14:40
 * @Description:
 */
public class DataSourceTest {
    @Test
    public void test1() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource druidDataSource =  ioc.getBean(DruidDataSource.class);
        System.out.println(druidDataSource.getConnection());
    }
}
