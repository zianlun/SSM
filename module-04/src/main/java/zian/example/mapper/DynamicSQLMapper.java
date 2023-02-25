package zian.example.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import zian.example.pojo.Employee;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/24/15:51
 * @Description:
 */
public interface DynamicSQLMapper {
    /***
    * @Description:插入一个员工，并且指定员工的部门
    * @Author: ljzhang
    * @Date: 2023/2/24
    */
    int insertEmployee(@Param("employee") Employee employee, @Param("depId") Integer depId);
    /***
    * @Description:根据相关信息筛选满足条件的员工
    * @Author: ljzhang
    * @Date: 2023/2/24
    */
    ArrayList<Employee> queryEmployeeByLabel(Employee employee);

    /***
    * @Description:查询满足其中一个条件标签的员工,前面已经有标签满足就不管后面的了
    * @Author: ljzhang
    * @Date: 2023/2/24
    */
    @MapKey("empId")
    HashMap<String,?> queryEmployByOneLabel(Employee employee);
    /***
    * @Description:批量添加员工
    * @Author: ljzhang
    * @Date: 2023/2/24
    */
    int insertEmps(@Param("emps") ArrayList<Employee> emps);

    /***
    * @Description:批量删除，传入的数据是一个id数组
    * @Author: ljzhang
    * @Date: 2023/2/24
    */
    int deleteEmps(@Param("empIds") Integer[] ids);
}
