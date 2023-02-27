package zian.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import zian.example.service.UserService;
import zian.example.service.impl.UserServiceImpl;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/26/23:04
 * @Description:
 *
 *
 *
 */
@Controller
public class UserController {

    private UserService userService;

    public void saveUser(){
        userService.saveUser();
    }

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
