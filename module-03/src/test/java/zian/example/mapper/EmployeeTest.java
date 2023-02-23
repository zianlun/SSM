package zian.example.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zian.example.pojo.Employee;
import zian.example.utils.SqlSessionUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/23/18:42
 * @Description:
 */
public class EmployeeTest {
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(null,"张飞",44,"男");
        employeeMapper.insertEmployee(employee);
        System.out.println(employee);
    }
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee =  employeeMapper.queryEmpById(3);
        System.out.println(employee);
    }
    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.queryEmpAndDepById(3);
        System.out.println(employee);
    }
}
