package zian.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zian.example.pojo.Student;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/26/17:48
 * @Description:
 */
public class ScopeTest {
    @Test
    public void test1(){
        ApplicationContext application = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student student1  = application.getBean(Student.class);
        Student student2 = application.getBean(student1.getClass());
        System.out.println(student1 == student2);
    }
}
