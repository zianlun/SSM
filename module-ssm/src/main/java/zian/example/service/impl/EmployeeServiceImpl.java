package zian.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zian.example.mapper.EmployeeMapper;
import zian.example.pojo.Employee;
import zian.example.service.EmployeeService;

import java.util.ArrayList;

/**
 * @ClassName EmployeeSerrviceImpl
 * @Description
 * @Author ljzhang
 * @Date 2023/3/11 19:09
 * @Version 1.0
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public ArrayList<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getAllEmpPage(Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        ArrayList<Employee> emps = employeeMapper.getAllEmployee();
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps, 6);
        return pageInfo;
    }
}
