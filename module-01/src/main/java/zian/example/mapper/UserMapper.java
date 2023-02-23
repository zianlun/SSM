package zian.example.mapper;

import zian.example.pojo.User;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/22/11:24
 * @Description:
 */
public interface UserMapper {
    /***
    * @Description: 用户表的增加操作
    * @Author: ljzhang
    * @Date: 2023/2/22
    */
    int insertUser();
    /***
    * @Description: 用户表更新
    * @Author: ljzhang
    * @Date: 2023/2/22
    */
    void updateUser();
    /***
    * @Description:用户表的删除
    * @Author: ljzhang
    * @Date: 2023/2/22
    */
    int deleteUser();
    /***
    * @Description:查询所有用户的信息
    * @Author: ljzhang
    * @Date: 2023/2/22
    */
    ArrayList<User>  selectUser();
    /***
    * @Description: `查询单个用户的信息
    * @Author: ljzhang
    * @Date: 2023/2/22
    */
    User selectOneUser();
}
