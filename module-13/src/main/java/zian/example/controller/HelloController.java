package zian.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/03/03/11:58
 * @Description:
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    public String protal(){
        //返回逻辑视图
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }

}
