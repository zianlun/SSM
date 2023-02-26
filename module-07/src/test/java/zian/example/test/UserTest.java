package zian.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zian.example.pojo.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/26/10:42
 * @Description:
 */
public class UserTest {
    @Test
    public void test1(){
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}
