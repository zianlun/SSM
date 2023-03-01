package zian.example.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/28/16:05
 * @Description:
 */
public interface UserMapper {
    /***
    * @Description: 按照id更新余额
    * @Param: [userId, price]
    * @return: int
    * @Author: ljzhang
    * @Date: 2023/3/1
    */
    int updateBalance(@Param("userId") Integer userId, @Param("price") Double price);
}
