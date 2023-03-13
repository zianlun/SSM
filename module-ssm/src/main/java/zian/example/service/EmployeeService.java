package zian.example.service;

import com.github.pagehelper.PageInfo;
import zian.example.pojo.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    /* **
       * @MethodName getAllEmployee
       * @Description：获取所有员工信息
       * @Author ljzhang
       * @Date
       */
    ArrayList<Employee> getAllEmployee();

    /* **
       * @MethodName getAllEmpPage
       * @Description  获取所有员工信息，包括分页功能的实现
       * @Author ljzhang
       * @Date
       */
    PageInfo<Employee> getAllEmpPage(Integer pageNum);
}
