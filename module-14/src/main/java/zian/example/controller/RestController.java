package zian.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/03/05/14:10
 * @Description:
 * 查询所有的用户信息 ---> /user --> get
 * 根据id查询用户信息 ---> /user/1 --> get
 * 添加用户信息 ---> /user --> post
 * 修改用户信息 ---> /user --> put
 * 删除用户信息 ---> /user/1 --> delete
 *
 */
@Controller
public class RestController {
    //@RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }
    //@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable("userId") Integer userId){
        System.out.println("查询用户信息");
        System.out.println("用户的编号为：" + userId);
        return "index";
    }


    //@RequestMapping(value="/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String updateUser(){
        System.out.println("put请求");
        return "index";
    }

    //@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    @DeleteMapping("/user/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId){
        System.out.println(userId + "已经被删除");
        return "success";
    }


}
