package zian.example.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import zian.example.pojo.Book;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/28/16:05
 * @Description:
 */

public interface BookMapper {
    /**
    * @Description: 更新图书内存,减一操作
    * @Param: [bookId]
    * @return: int
    * @Author: ljzhang
    * @Date: 2023/2/28
    */
    int updateStack(@Param("bookId") Integer bookId);

    /***
    * @Description: 查询图书价格
    * @Param: [bookId]
    * @return: double
    * @Author: ljzhang
    * @Date: 2023/2/28
    */
    double queryBookPrice(@Param("bookId")Integer bookId);

    /***
    * @Description:查询全部图书的信息
    * @Author: ljzhang
    * @Date: 2023/3/1
    */
    @MapKey("bookId")
    Map<Integer, Book> queryAllBook();
}
