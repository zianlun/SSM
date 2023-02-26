package zian.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zian.example.pojo.Student;

/**
 * Created with IntelliJ IDEA.
 *获取bean的三种和方式
 * ---根据bean的id获取
 * ---根据bean的类型获取
 * -----根据类型获取bean时，要求ioc容器中有且只要一个类型匹配的bean
 * -----若没有任何一个类型匹配的bean，此时抛出异常，noSuchBeanDefinintionException
 * -----若有多个类型匹配的bean，抛出异常：noUniqueBeanDefinInitionException
 *---根据bean和id获取
 * @Author: ljzhang
 * @Date: 2023/02/26/10:50
 * @Description:
 */
public class StudentTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = applicationContext.getBean("studentOne",Student.class);
        Student student2 = applicationContext.getBean("studentThree",Student.class);
        System.out.println(student2);
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = applicationContext.getBean("studentFive",Student.class);
        Student student2 = applicationContext.getBean("studentSix",Student.class);
        System.out.println(student2);
        System.out.println(student1);
    }
    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = applicationContext.getBean("studentEleven",Student.class);
        System.out.println(student1);
    }
    @Test
    public void test4(){

    }
}
