package zian.example.dao;

import org.springframework.stereotype.Repository;
import zian.example.pojo.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/03/05/22:12
 * @Description:
 */
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> emps = new HashMap<Integer,Employee>();

    private static Integer id = 10086;


    static {
        emps.put(id,new Employee(id++,"安天帝","313@qq.com",1));
        emps.put(id,new Employee(id++,"玉子安","3133@qq.com",0));
        emps.put(id,new Employee(id++,"ljzhang","3213@qq.com",0));
        emps.put(id,new Employee(id++,"zian","3123@qq.com",1));
        emps.put(id,new Employee(id++,"杰安","3123@qq.com",1));
        emps.put(id,new Employee(id++,"晓峰","3123@qq.com",1));
    }

    public EmployeeDao() {
    }

    public boolean addEmp(Employee employee){
        if(employee.getId() == null){
            employee.setId(id++);
        }
        emps.put(employee.getId(),employee);
        System.out.println(emps);
        return true;
    }

    public boolean deleteEmp(Integer id){
        emps.remove(id);
        return true;
    }


    public Collection<Employee> emps(){
        return emps.values();
    }

    public Employee getById(Integer id){
        return emps.get(id);
    }
}
