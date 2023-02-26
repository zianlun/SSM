package zian.example.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zian.example.pojo.Employee;
import zian.example.pojo.EmployeeExample;
import zian.example.utils.SqlSessionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/25/12:13
 * @Description:
 */
public class EmployeeTest {
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp1 = employeeMapper.selectByPrimaryKey(2);
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andAgeBetween(10,20);
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        employees.forEach(System.out::println);
        System.out.println(emp1);

        employeeMapper.updateByPrimaryKeySelective(new Employee(3,"关羽",null,"男"));
    }
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Page<Object> page= PageHelper.startPage(1,2);
        List<Employee> emps = employeeMapper.selectByExample(null);
        PageInfo<Employee> pageInfo = new PageInfo<>(emps, 4);
        System.out.println(pageInfo);
        emps.forEach(System.out::println);
    }
}
