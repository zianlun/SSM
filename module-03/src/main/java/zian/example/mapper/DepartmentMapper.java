package zian.example.mapper;

import org.apache.ibatis.annotations.Param;
import zian.example.pojo.Department;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/24/10:00
 * @Description:
 */
public interface DepartmentMapper {
    /***
    * @Description:分布查询第二部查询员部门
    * @Author: ljzhang
    * @Date: 2023/2/24
    */
    Department queryInfoByIdTwo(@Param("depId") Integer depId);

    /***
    * @Description:查询部门的所有员工信息
    * @Author: ljzhang
    * @Date: 2023/2/24
    */
    Department queryAllEmps(@Param("depId") Integer depId);

    /***
     * @Description:查询部门的所有员工信息-----分布查询一
     * @Author: ljzhang
     * @Date: 2023/2/24
     */
    Department queryAllEmpsStepOne(@Param("depId") Integer depId);
}
