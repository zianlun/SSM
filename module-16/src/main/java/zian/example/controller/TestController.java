package zian.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName TestController
 * @Description
 * @Author ljzhang
 * @Date 2023/3/11 12:05
 * @Version 1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public void hello(HttpServletResponse response) throws IOException {
        int a = 1 / 0;
        response.getWriter().write("<h1>hello</h1>");
    }

}
