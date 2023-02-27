package zian.example.pojo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/27/19:09
 * @Description:
 * 在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before: 前置通知，在目标对象方法执行之前执行
 * @After: 后置通知，在目标对象方法finally子句中执行
 *
 * 1、切入点表达式：设置在标识通知的注解value属性中
 * execution(public int zian.example.pojo.CalculatorImpl.mul(int, int))
 * 2、* zian.example.pojo.CalculatorImpl.*(..))
 * 第一个*表示类中任意的访问修饰符和返回值类型
 * 第二个*表示类中任意的方法
 * ...表示任意的参数列表
 * 类的地方也可以使用*，表示包下所有的类
 * 3、重用切入点表达式 @Pointcut
 * 放在一个没有参数，没有方法体的函数上面
 *     @Pointcut("execution(* zian.example.pojo.CalculatorImpl.*(..))")
 *     public void pointCut(){};
 *
 */
@Component
@Aspect //将当前组件标识为切面
public class LoggerAspect {
    //前置通知的方法——需要相关的注解
    //参数为切入点表达式
    //@Before("execution(public int zian.example.pojo.CalculatorImpl.mul(int, int))")

    @Pointcut("execution(* zian.example.pojo.CalculatorImpl.*(..))")
    public void pointCut(){};


    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        System.out.println("前置通知, 调用方法" + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args).toString());
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        System.out.println("后置通知, 调用方法" + joinPoint.getSignature().getName());
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
    }

}
