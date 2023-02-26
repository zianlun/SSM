package zian.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zian.example.pojo.Clazz;
import zian.example.pojo.Student;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/26/12:26
 * @Description:
 */
public class ClazzTest {
    @Test
    public void test1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazz = ioc.getBean("clazzThree", Clazz.class);
        System.out.println(clazz);
        clazz.getStus().forEach(System.out::println);
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean("studentEight",Student.class);
        System.out.println(student);
        student.getTeachers().entrySet().forEach(System.out::println);
    }
    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean("studentNine",Student.class);
        System.out.println(student);
        student.getTeachers().entrySet().forEach(System.out::println);
    }
    @Test
    public void test4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean("studentTen",Student.class);
        System.out.println(student);
    }
}
