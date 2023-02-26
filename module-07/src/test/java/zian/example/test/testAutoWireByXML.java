package zian.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zian.example.Controller.UserController;
import zian.example.pojo.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/26/19:57
 * @Description:
 * 自动装配：
 *        根据指定的策略，在ioc容器中匹配某个bean，自动为bean中的类型的属性或接口类型的属性赋值
 *        可以通过bean标签中的autoWire属性设置自动装配的策略
 *        自动装配的策略：
 *        no，deault，表示不装配，即bean中的属性不会自动匹配某个bean为属性值，此时属性使用默认值
 *        byType:根据要赋值的属性类型，在ioc容器中匹配某个bean，为属性赋值
 *        a> 若通过类型没有找到任何一个类型匹配的bean，此时不装配，属性使用默认值
 *        a< 若通过类型找到了多个类型匹配的bean，此时会抛出异常：NoUniqueBeanDefinitionException
 *        总结：当使用byType实现自动装配的时，ioc容器中有且只有一个类型匹配的bean能够为属性赋值
 *        byName:要赋值的属性名要和bean的id相同
 *        当类型匹配的bean有多个时，此时可以使用byName实现自动装配
 * @Description:
 * @Author: ljzhang
 * @Date: 2023/2/26
 */

public class testAutoWireByXML {
    @Test
    public void test1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("autoWire.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
