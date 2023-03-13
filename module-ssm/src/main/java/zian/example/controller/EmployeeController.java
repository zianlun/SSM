package zian.example.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zian.example.pojo.Employee;
import zian.example.service.EmployeeService;

import java.util.ArrayList;

/**
 * @ClassName EmployeeController
 * @Description:
 * 查询所有的员工信息——/employee/allEmployee/ ---> get
 * 根据id查询员工——/employee/idEmployee/ ---> get
 * 跳转到添加页面——/employee/toAdd/ ---> get
 * 添加员工信息——/employee/addEmployee/ ---> post
 * 修改员工信息——/employee/updateEmployee/ ---> put
 * 删除员工信息——/employee/deleteEmployee/ ---> delete
 * @Author ljzhang
 * @Date 2023/3/11 19:11
 * @Version 1.0
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/allEmployee")
    public String allEmployee(Model model){
        ArrayList<?> emps = employeeService.getAllEmployee();
        model.addAttribute("emps", emps);
        return "employeeList";
    }

    @GetMapping("/byIdEmployee")
    public String byIdEmployee(){
        return "emploeeInfo";
    }

    @GetMapping("/pageEmployee/{pageNum}")
    public String pageEmployee(Model model, @PathVariable("pageNum") Integer pageNum){
        PageInfo<Employee> page = employeeService.getAllEmpPage(pageNum);
        System.out.println(page);
        model.addAttribute("page", page);
        return "employeePage";
    }
}
