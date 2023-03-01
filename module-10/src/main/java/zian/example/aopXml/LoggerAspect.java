package zian.example.aopXml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
/***
* @Description:
* @Author: ljzhang
* @Date: 2023/2/28
*/
@Component
public class LoggerAspect {

    public void beforeAdviceMethod(JoinPoint joinPoint){
        System.out.println("【日志】前置通知 ----- 调用方法" + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        System.out.println("【日志】参数信息 ----" + Arrays.toString(args).toString());
    }

    public void afterAdviceMethod(JoinPoint joinPoint){
        System.out.println("【日志】后置通知 ----- 方法结束" + joinPoint.getSignature().getName());
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
    }

    public void afterReturingAdviceMethod(JoinPoint joinPoint, Object result){
        System.out.println("【日志】返回通知 ---- 返回参数：" + result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable throwable){
        System.out.println("【日志】异常通知 ---- 抛出异常：" + throwable);
    }

}
