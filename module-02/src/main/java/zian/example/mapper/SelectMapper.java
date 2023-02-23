package zian.example.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import zian.example.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/23/13:24
 * @Description:模糊查询用户
 */
public interface SelectMapper {
    /***
    * @Description:模糊查询——可以用三种方式
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    List<User> queryUserLike(@Param("username") String username);
    /***
    * @Description:批量删除用户————根据id是否被选中
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    void deleteMoreUser(@Param("ids") String ids);
    /***
    * @Description:动态设置表名查询用户
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    @MapKey("id")
    Map<String, ?> queryAllUserByTable(@Param("tableName") String tableName);
    /***
    * @Description:添加用户——获取自增的主键
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    int insertUser(User user);
}
