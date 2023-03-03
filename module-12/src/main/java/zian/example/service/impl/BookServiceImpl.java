package zian.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zian.example.Utils.SqlSessionUtil;
import zian.example.mapper.BookMapper;
import zian.example.mapper.UserMapper;
import zian.example.service.BookService;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/28/16:10
 * @Description:
 */
@Service
public class BookServiceImpl implements BookService {
    private BookMapper bookDao = SqlSessionUtil.getSqlSession().getMapper(BookMapper.class);
    private UserMapper userDao = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);
    @Override
    @Transactional
    public boolean buyBook(Integer userId, Integer bookId) {
        //查询数据库图书价格
        Double price = bookDao.queryBookPrice(bookId);
        //更新库存
        bookDao.updateStack(bookId);
        //更新余额
        int result = userDao.updateBalance(userId,price);
        System.out.println(price);
        if(result == 0)
            return false;
        return true;
    }

    @Override
    public boolean checkOut(Integer userId, Integer[] books) {
        for (Integer bookId:books) {
            buyBook(userId, bookId);
        }
        return true;
    }

    public BookServiceImpl() {}

    public BookServiceImpl(BookMapper bookDao, UserMapper userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }
}
