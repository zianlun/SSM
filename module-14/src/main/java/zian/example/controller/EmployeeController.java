package zian.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import zian.example.dao.EmployeeDao;
import zian.example.pojo.Employee;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/03/05/22:26
 * @Description:
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getAll")
    public String getAll(Model model){
        model.addAttribute("emps",employeeDao.emps());
        return "list";
    }
}
