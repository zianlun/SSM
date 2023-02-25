package zian.example.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zian.example.Utils.SqlSessionUtil;
import zian.example.pojo.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/24/15:58
 * @Description:
 */
public class DynamicSQLTest {
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper  dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Employee employee = new Employee(null, "ljzhang", 18, "男");
        int result = dynamicSQLMapper.insertEmployee(employee,2);
        System.out.println(result);
    }
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Employee employee = new Employee(null, "ljzhang", -1, null);
        ArrayList<Employee> emps = dynamicSQLMapper.queryEmployeeByLabel(employee);
        System.out.println(emps);
    }
    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Employee employee = new Employee(null, null, -1, "女");
        Map<String, ?> emps = dynamicSQLMapper.queryEmployByOneLabel(employee);
        System.out.println(emps);
    }
    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        ArrayList<Employee> emps = new ArrayList<Employee>();
        emps.add(new Employee(null, "zian", 58, "女"));
        emps.add(new Employee(null, "alun", 29, "男"));
        emps.add(new Employee(null, "lunlun", 100, "女"));
        emps.add(new Employee(null, "jiean", 50,"男"));
        dynamicSQLMapper.insertEmps(emps);
        System.out.println(emps);
    }
    @Test
    public void test5(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer empIds[] = new Integer[]{5,10,4};
        int result = dynamicSQLMapper.deleteEmps(empIds);
        System.out.println(result);
    }

}
