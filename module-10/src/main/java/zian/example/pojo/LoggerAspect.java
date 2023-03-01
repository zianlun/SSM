package zian.example.pojo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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


    /***
    * @Description:获取连接点信息——设置JoinPoint类型的形参
    * @Author: ljzhang
    * @Date: 2023/2/28
    */
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        System.out.println("【日志】前置通知 ----- 调用方法" + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        System.out.println("【日志】参数信息 ----" + Arrays.toString(args).toString());
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        System.out.println("【日志】后置通知 ----- 方法结束" + joinPoint.getSignature().getName());
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
    }

    /***
     * @Description:获取目标方法的返回值
     * @Author: ljzhang
     * @Date: 2023/2/28
     */
    @AfterReturning(value="pointCut()", returning="result")
    public void afterReturingAdviceMethod(JoinPoint joinPoint, Object result){
        System.out.println("【日志】返回通知 ---- 返回参数：" + result);
    }

    @AfterThrowing(value="pointCut()", throwing="throwable")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable throwable){
        System.out.println("【日志】异常通知 ---- 抛出异常：" + throwable);
    }

    /***环绕通知
    * @Description:
    * @Author: ljzhang
    * @Date: 2023/2/28
    */
   /* @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
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
    }*/

}
