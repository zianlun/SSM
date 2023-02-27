package zian.example.pojo;

import org.springframework.stereotype.Component;
import zian.example.pojo.Calculator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/27/16:00
 * @Description:
 */
@Component
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int a, int b) {
        int result = a + b;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a - b;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public double div(int a, int b) throws Exception {
        if(b == 0)
            throw new Exception("除数不能为0");
        double result = a / b;
        System.out.println("方法内部 result = " + result);
        return 0;
    }

    @Override
    public int mul(int a, int b) {
        int result = a * b;
        System.out.println("方法内部 result = " + result);
        return 0;
    }
}
