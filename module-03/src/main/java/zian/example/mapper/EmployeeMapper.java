package zian.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import zian.example.pojo.Employee;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/23/18:33
 * @Description:
 */
interface EmployeeMapper {
    /***
    * @Description:插入一个用户
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
   int insertEmployee(Employee employee);
   /***
   * @Description:通过id查询员工
   * @Author: ljzhang
   * @Date: 2023/2/23
   */
   Employee queryEmpById(@Param("id") Integer id);
   /***
   * @Description:用外连接查询两个表，同时限制员工id
   * @Author: ljzhang
   * @Date: 2023/2/23
   */
   Employee queryEmpAndDepById(@Param("id") Integer id);
   /***
   * @Description:查询员工信息——分布查询
   * @Author: ljzhang
   * @Date: 2023/2/24
   */
   Employee queryInfoByIdOne(@Param("empId") Integer empId);
   /***
   * @Description:查询一个部门全部员工的信息——分布查询
   * @Author: ljzhang
   * @Date: 2023/2/24
   */
   Employee queryAllEmpsStepTwo(@Param("depId") Integer depId);
}
