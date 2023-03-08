package zian.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/03/04/15:13
 * @Description:
 * 1、ModelAndView 包含Model 和 View的功能
 * 2、model、map、ModelMap 都是class org.springframework.validation.support.BindingAwareModelMap
 */
@Controller
public class ScopeController {
    @RequestMapping("/scope/test1")
    public ModelAndView mav1(){
        /***
        * ModelAndView 包含Model 和 View的功能
         * Model：向请求域中共享数据——可以使用model功能向请求域共享数据
         * View：设置逻辑视图实现页面跳转，使用View功能设置逻辑视图，但控制器一定要将modelandview作为方法的返回值
        */
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(modelAndView.getClass());
        //向请求域中共享数据
        modelAndView.addObject("username","张伦杰");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/scope/test2")
    public String mav1(Model model){
        System.out.println(model.getClass());
        model.addAttribute("username","玉子安");
        return "index";
    }

    @RequestMapping("/scope/test3")
    public String modelMap(ModelMap modelMap){
        System.out.println(modelMap.getClass());
        modelMap.addAttribute("username","ljzhang");
        return "index";
    }

    @RequestMapping("/scope/test4")
    public String map1(Map map){
        map.put("username","安天帝");
        return "index";
    }

    @RequestMapping("/scope/test5")
    public String testSession(HttpSession session){
        session.setAttribute("username2","张伦杰");
        return "index";
    }

    @RequestMapping("/scope/test6")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("username3","玉子安");
        return "index";
    }

}
