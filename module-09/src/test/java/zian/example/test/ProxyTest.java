package zian.example.test;

import org.junit.Test;
import zian.example.pojo.Calculator;
import zian.example.pojo.CalculatorProxy;
import zian.example.pojo.ProxyFactory;
import zian.example.pojo.impl.CalculatorImpl;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/27/16:46
 * @Description:
 */
public class ProxyTest {
    /***
    * @Description:静态代理
    * @Author: ljzhang
    * @Date: 2023/2/27
    */
    @Test
    public void test1() throws Exception {
        Calculator calculator = new CalculatorProxy(new CalculatorImpl());
        System.out.println(calculator.add(2, 6));
        System.out.println(calculator.mul(3, 5));
        System.out.println(calculator.div(3, 2));
        System.out.println(calculator.mul(3, 5));
    }
    /***
    * @Description:动态代理
    * @Author: ljzhang
    * @Date: 2023/2/27
    */
    @Test
    public void test2(){

        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());

        Calculator proxyCalcultor = (Calculator)proxyFactory.getProxy();

        proxyCalcultor.add(2,4);
    }
}
