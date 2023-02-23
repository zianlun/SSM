package zian.example.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import zian.example.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/22/20:48
 * @Description:
 */
public interface UserMapper {
    /***
    * @Description：查询年龄大于18的用户信息
    * @Author: ljzhang
    * @Date: 2023/2/22
    */
    ArrayList<User> selectUserAge();
    /***
    * @Description:根据id查询用户
    * @Author: ljzhang
    * @Date: 2023/2/22
    */
    User selectUserById(int id);
    /***
    * @Description:按照用户名查找用户信息
    * @Author: ljzhang
    * @Date: 2023/2/22
    */
    User selectUserByName(String username);
    /***
    * @Description:登录验证——使用arg0，arg1或者param1和param2 传递参数  可以混用
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    User verifyLogin(String username, String password);
    /***
    * @Description:接口参数为map，查询满足两个条件的用户
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    ArrayList<User> queryUserByAgeAndGender(Map<String , ?> map);
    /***
    * @Description:实体类获取参数 插入一个用户
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    void insertUser(User user);
    /***
    * @Description:通过id查询用户
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    User queryUserByIdParam(@Param("id") Integer id);
    /***
    * @Description:更新用户表的所有密码
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    int updatePassWord(@Param("password") String password);
    /***
    * @Description:聚合函数的查询——查询user表中>=id总人数，根据id查询
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    int querySumUser(@Param("id") Integer id);
    /***
    * @Description:根据用户名查询结果保存到map中
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    Map<String, ?> queryUserByUserNameToMap(@Param("username") String username);
    /****
    * @Description:查询年龄在一定范围内的用户
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    List<Map<String,?>> queryUserByAge(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);
    /***
    * @Description:同上个方法，但是用Map
     * 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，并
     * 且最终要以一个map的方式返回数据，此时需要通过@MapKey注解设置map集合的键，值是每条数据所对应的
     * map集合
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    @MapKey("id")
    Map<Integer,?> queryUserByAgeToMap(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);
}
