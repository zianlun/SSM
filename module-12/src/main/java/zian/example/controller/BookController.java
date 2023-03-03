package zian.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import zian.example.service.BookService;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/28/16:12
 * @Description:
 */
@Controller
public class BookController {

    private BookService bookService;

    /***
    * @Description:
    * @Param: [userId, bookId]
    * @return: boolean
    * @Author: ljzhang
    * @Date: 2023/2/28
    */
    public boolean buyBook(Integer userId, Integer bookId){
        return bookService.buyBook(userId,bookId);
    }

    public boolean checkOut(Integer userId, Integer[] books){
        return bookService.checkOut(userId, books);
    }

    public BookController() {
    }

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

}
