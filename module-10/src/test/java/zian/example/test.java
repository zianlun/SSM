package zian.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zian.example.pojo.Calculator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/27/19:23
 * @Description:
 */
public class test {
    @Test
    public void test1() throws Exception {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(2,2);
        System.out.println(Integer.MAX_VALUE + "最小"+ Integer.MIN_VALUE);
    }
}
