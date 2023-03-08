package zian.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import zian.example.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/03/03/13:14
 * @Description:
 * 1、标识位置的不同
 * @RequestMapping 标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求路径的具体信息
 * 2、@RequestMapping主机value属性
 * 作用：通过请求的请求路径匹配请求
 * value属性是数组类型，即当前浏览器所发送请求的请求路径匹配value属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 * 3、method请求方式 post、get
 * 作用：通过请求的情趣方式匹配请求
 * method属性是requestMethod类型的数组，即当前浏览器所发送请求
 * 的请求方式匹配method属性中的任何一种，则当前请求就会被注解所标识
 * 的方法进行处理
 * 若浏览器所发送请求的请求路径和@RequestMapping主机匹配，当请求方式不匹配
 * 此时页面报错：405
 * 结合请求方式的一些派生注解：
 * @GetMapping,@PostMapping,@DeleteMapping,@PutMapping
 * 4、@RequestMapping注解params属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
 * params可以使用四种表达式：
 * "param":表示当前所匹配的请求的请求参数种必须携带param参数
 * "!param":不能携带
 * "param=value"：携带并且值为value
 * "param!=value"：可以携带哦或者不携带，但是值不能为value
 * 若浏览器所发送请求的请求路径和@RequestMapping主机匹配
 * params不满足要求：400
 * 5、@RequestMapping注解headers属性
 * 作用：通过请求的请求头信息匹配请求，浏览器发送的请求头信息必须满足headers属性设置
 * 若浏览器所发送请求的请求路径和@RequestMapping主机匹配，header不匹配
 * 不匹配：404
 *
 *
 * @RequestMapping注解使用路径中的占位符
 * 传统：/deleteUser?id=1
 * rest:/user/delete/1
 * 需要在@RequestMapping注解的value属性中所设置的路径中，使用{xxx}的方式表示路径中的数据
 * 在通过@PathVariable注解
 *
 * 获取请求参数的方式
 * 1、通过ServletAPI获取
 * 只需要在控制器的形参方法位置设置HttpServeltRequest类型的形参，就可以在
 * 控制器方法中使用request对象方法中使用request对象获取请求参数
 *
 * 2、通过控制器方法的形参获取
 * 只需要在控制器方法的形参位置，设置一个形参，形参的名字和请求参数的名字一致即可。
 *
 *
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/login/servletAPI",
            method = RequestMethod.GET
    )
    public String login(HttpServletRequest request){
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        String password = request.getParameter("password");
        System.out.println("email  :" + email);
        System.out.println("password  :" + password);
        return "index";
    }

    @RequestMapping("/login/requestName")
    public String getParam1(String email, String password){
        System.out.println("email  :" + email);
        System.out.println("password  :" + password);
        return "index";
    }

    /***
    * @Description:如果前后端属性名不一样，使用RequestParam
    * @Author: ljzhang
    * @Date: 2023/3/3
    */
    @RequestMapping("/login/requestParam")
    public String getParam2(@RequestParam("email") String count,@RequestParam("password") String password){
        System.out.println("email  :" + count);
        System.out.println("password  :" + password);
        return "index";
    }

    /***
    * @Description:接受post请求
    * @Author: ljzhang
    * @Date: 2023/3/3
    */
    @RequestMapping(value = "/login",
            method = {RequestMethod.GET})
    public String getParam3(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpServletRequest  request
            ){
        request.getSession();
        System.out.println("email  :" + email);
        System.out.println("password   :" + password);
        return "index";
    }
    @RequestMapping(value = "/submit/info", method = RequestMethod.POST)
    public String getUserInfo(
            @RequestParam("count") String count,
            @RequestParam("password") String password,
            @RequestParam("age") Integer age,
            @RequestParam("sex") String sex){
        System.out.println("count" + count);
        System.out.println("password" + password);
        System.out.println("age" + age);
        System.out.println("sex" + sex);
        return "index";
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String getUserPojo(User user){
        System.out.println(user);
        return "index";
    }
}
