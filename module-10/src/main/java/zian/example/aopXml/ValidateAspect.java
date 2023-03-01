package zian.example.aopXml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/28/13:12
 * @Description:
 */
@Component
@Aspect
@Order(10086)
public class ValidateAspect {
    /*调用其他包下的可重用切入点*/
    @Around("zian.example.aopXml.LoggerAspect.pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("环绕通知-----前置通知");
            result = joinPoint.proceed();
            System.out.println("环绕通知-----返回通知");
        } catch (Throwable throwable) {
            System.out.println("环绕通知-----异常通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("环绕通知-----后置通知");
        }
        return result;
    }
}
