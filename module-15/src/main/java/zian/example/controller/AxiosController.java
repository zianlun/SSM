package zian.example.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zian.example.pojo.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

/**
 * @ClassName AxiosController
 * @Description
 * 1、@ResponseBody:将请求体中的内容和控制器方法的形参进行绑定
 * 2、使用@ResponseBody注解将json格式的请求参数转换为java对象
 * a>导入jackson的依赖
 * b>在springmvc的配置文件中设置<mvn:annotation-driven/>
 * c>在处理请求的控制器方法的形参的位置，直接设置json格式的请求参数要转换的java类型的形参
 * 使用RequestBody标识即可
 * 3、@ResponseBody:将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器\
 * 4、使用@ResponBody:将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
 *  a>导入jackson的依赖
 *  b>在springmvc的配置文件中设置<mvn:annotation-driven/>
 *  c>将需要转换为json字符串的java对象直接作为控制器方法的返回值，使用@ResponBody
 *  注解标识控制器方法就可以将java对象直接转换为json字符串，并响应到浏览器
 *
 *  常用的Java对象转换为json的结果：
 *  实体类 --> json对象
 *   map --> json 对象
 *   list --> json 数组
 *
 *  5、文件上传功能的实现
 *  1、form表单的提交方式必须为post
 *  2、form表单必须设置属性enctype="multipart/form-data"
 *
 * @Author ljzhang
 * @Date 2023/3/9 20:55
 * @Version 1.0
 */
@Controller
@RequestMapping("/test")
public class AxiosController {
    @PostMapping("/hello")
    public void hello(
            @RequestParam("id") Integer id,
            @RequestBody String requestBody,
            HttpServletResponse response) throws IOException {
        System.out.println(requestBody);
        response.getWriter().write("hello: " + id);
        System.out.println(id);
    }

    @PostMapping("/jsonTest")
    public void jsonTest(
            @RequestBody User user,
            HttpServletResponse response) throws IOException {
        System.out.println("用户登录成功： " + user);
        response.getWriter().write("200ok");
    }

    @PostMapping("/mapTest")
    public void mapTest(
            @RequestBody Map<String, ?> map,
            HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello, map,200ok");
    }

    @PostMapping("/responseTest")
    @ResponseBody
    public String responseTest(
            @RequestBody Map<String, ?> map) throws IOException {
        return "<h1>成功跳转 </h1>";
    }

    @ResponseBody
    @GetMapping("/getUser")
    public List<User> getUser(){
        User user1 = new User(10086,"ljzhang","921q734","31378283","男");
        User user2 = new User(10086,"玉子安","921q734","31378283","男");
        User user3 = new User(10086,"zian","921q734","31378283","男");
        return Arrays.asList(user1,user2,user3);
    }

    //文件下载请求处理
    @GetMapping("/download")
    public ResponseEntity<byte[]> downTest(HttpSession session) throws Exception {
        //1、获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //2、获取下载文件路径
        String path = "img" + File.separator + "壁纸02.jpg";
        String realPath = servletContext.getRealPath(path);
        //3、创建输入流
        InputStream is = new FileInputStream(realPath);
        //4、创建字节数组 is.available()获取输入流对应文件的字节数
        byte[] bytes = new byte[is.available()];
        //5、将字节流读入到字节数组中
        is.read(bytes);
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=壁纸.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        is.close();
        return responseEntity;
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile photo, HttpSession session) throws IOException {
        //1、获取上传文件的文件名
        String fileName = photo.getOriginalFilename();
        String sufName = fileName.substring(fileName.lastIndexOf('.'));
        String uid = UUID.randomUUID().toString();
        fileName = uid + sufName;
        //2、获取servletContext对象
        ServletContext serveletContext = session.getServletContext();
        //3、获取当前工程img目录的真实路径
        String realPath = serveletContext.getRealPath("img");
        //4、创建对应的文件对象
        File file = new File(realPath);

        if(!file.exists()){
            file.mkdir();
        }
        //5、拼接最终地址
        String finalPath = realPath + File.separator + fileName;
        //上传文件
        photo.transferTo(new File(finalPath));
        return "ok";
    }
}
