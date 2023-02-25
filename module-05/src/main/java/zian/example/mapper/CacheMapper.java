package zian.example.mapper;

import org.apache.ibatis.annotations.Param;
import zian.example.pojo.Employee;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/24/22:13
 * @Description:
 */
public interface CacheMapper {
    /***
    * @Description:通过一个id查询一个员工信息
     * 学习一级缓存原理
    * @Author: ljzhang
    * @Date: 2023/2/24
    */
    Employee queryEmployee(@Param("empId") Integer empId);

    /**
     * 更新一个员工信息，按照id
     * @param empId
     * @param emp
     * @return
     */
    int updateEmployee(@Param("empId")Integer empId, @Param("emp") Employee emp);
}
