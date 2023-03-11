package zian.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/addEmployee")
    public String addEmployee(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("gender") Integer gender) {
        employeeDao.addEmp(new Employee(null, name, email, gender));
        return "redirect:/getAll";
    }

    @GetMapping("/employee/update/{id}")
    public String tranUpdate(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.getById(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(
            Employee employee) {
        System.out.println(employee);
        employeeDao.addEmp(employee);
        return "redirect:/getAll";
    }

    @DeleteMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.deleteEmp(id);
        return "redirect:/getAll";
    }
}
