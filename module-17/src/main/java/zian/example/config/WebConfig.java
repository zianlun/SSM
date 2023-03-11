package zian.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import zian.example.interceptor.FirstInterceptor;

import java.util.List;
import java.util.Properties;

/**
 * @ClassName WebConfig
 * @Description：代替springmvc的配置文件
 * 扫描组件、视图解析器、默认的servlet、MVC的注解驱动
 * 试图控制器、文件上传解析器、拦截器、异常解析器
 *
 * @Author ljzhang
 * @Date 2023/3/11 13:50
 * @Version 1.0
 */
//将类标识为配置类
@Configuration
//扫描注解  value--->扫描的包
@ComponentScan("zian.example.controller")
//开启mvc的注解驱动
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    //默认的sevlet的处理  ---- 处理静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*WebMvcConfigurer.super.addViewControllers(registry);*/
        //设置路径地址和逻辑视图
        registry.addViewController("/").setViewName("index");
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FirstInterceptor()).addPathPatterns("/**");
    }

    //文件上传解析器——本质上是配置一个bean
    //@Bean可以将方法的返回值作为bean进行管理,bean的id为方法的方法名
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }

    //异常解析器
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties prop = new Properties();
        prop.setProperty("java.lang.AritmeticException","error");
        simpleMappingExceptionResolver.setExceptionMappings(prop);
        simpleMappingExceptionResolver.setExceptionAttribute("ex");
        resolvers.add(simpleMappingExceptionResolver);
    }

    //视图解析器
    //生成视图解析器并未解析器注入模板引擎
    //生成模板引擎并为模板引擎注入模板解析器
    @Bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext =
                ContextLoader.getCurrentWebApplicationContext();
        ServletContextTemplateResolver templateResolver = new
                ServletContextTemplateResolver(
                webApplicationContext.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver
                                                       templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }
}
