package zian.example.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @ClassName WebInit
 * @Description
 * @Author ljzhang
 * @Date 2023/3/11 13:45
 * @Version 1.0
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    //设置一个配置类来代替spring的配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    //设置一个配置类来代替springmvc的配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //设置springmvc的前端控制器dispatcherservlet的url-pattern
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //设置当前的过滤器
    @Override
    protected Filter[] getServletFilters() {
        //创建编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        //设置请求的编码
        characterEncodingFilter.setEncoding("UTF-8");
        //设置响应的编码
        characterEncodingFilter.setForceEncoding(true);
        //创建请求方式的过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};
    }
}
