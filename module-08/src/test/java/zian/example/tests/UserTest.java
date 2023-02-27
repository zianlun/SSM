package zian.example.tests;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zian.example.controller.UserController;
import zian.example.dao.UserDao;
import zian.example.service.UserService;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/27/11:01
 * @Description:
 */
public class UserTest {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController1 = ioc.getBean(UserController.class);
        System.out.println(userController1.getUserService());
        System.out.println(userController1.getUserService());

    }
}
