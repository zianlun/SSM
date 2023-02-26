package zian.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zian.example.factory.UserFactory;
import zian.example.pojo.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/26/19:09
 * @Description:
 */
public class UserFactoryTest {
    @Test
    public void test1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user1 =  ioc.getBean(User.class);
        User user2 = ioc.getBean(User.class);
        System.out.println(user1);
    }
}
