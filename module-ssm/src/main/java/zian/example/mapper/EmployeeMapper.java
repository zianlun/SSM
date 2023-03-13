package zian.example.mapper;

import org.springframework.stereotype.Repository;
import zian.example.pojo.Employee;

import java.util.ArrayList;

/**
 * @InterfaceName EmployeeMapper
 * @Description
 * @Author ljzhang
 * @Date 2023/3/13 9:36
 * @Version 1.0
 */
@Repository
public interface EmployeeMapper {
    ArrayList<Employee> getAllEmployee();
}
