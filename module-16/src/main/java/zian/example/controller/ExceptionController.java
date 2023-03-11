package zian.example.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName ExceptionController
 * @Description
 * @Author ljzhang
 * @Date 2023/3/11 13:30
 * @Version 1.0
 */
//将当前类标识为异常处理组件
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable exception,  Model model){
        model.addAttribute("exception", exception);
        return "error";
    }
}
