package zian.example.pojo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/27/17:15
 * @Description:
 */
public class ProxyFactory {

    /**
     * 被代理类对象
     */
    private Object target;

    /***
    * @Description:构造函数，目的是为了传入被代理类的对象
    * @Author: ljzhang
    * @Date: 2023/2/27
    */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        /***
        * @Description:
         *loader: 应用类加载器
         *interfaces:接口集合
         *
        * @Author: ljzhang
        * @Date: 2023/2/27
        */
        InvocationHandler ih = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法" + method.getName() + "开始调用, 传入参数为 " + Arrays.toString(args));
                Object result = null;
                try {
                    result = method.invoke(target,args);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    System.out.println("方法调用出现异常");
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("方法执行完毕");
                }

                return result;
            }
        };

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                ih);
    }
}
