package zian.example.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zian.example.pojo.Department;
import zian.example.pojo.Employee;
import zian.example.utils.SqlSessionUtil;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/24/10:50
 * @Description:
 */
public class DepartmentTest {
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.queryAllEmps(1);
        System.out.println(department);
    }
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department dep = departmentMapper.queryAllEmpsStepOne(1);
        System.out.println(dep.getDepName());
    }
}
