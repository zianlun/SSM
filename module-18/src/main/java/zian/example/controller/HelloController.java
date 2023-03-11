package zian.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import zian.example.Service.HelloService;

/**
 * @ClassName HelloController
 * @Description
 * @Author ljzhang
 * @Date 2023/3/11 15:52
 * @Version 1.0
 */
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;
}
