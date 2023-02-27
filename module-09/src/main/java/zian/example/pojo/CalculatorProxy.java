package zian.example.pojo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/27/16:41
 * @Description:
 */
public class CalculatorProxy implements Calculator{
    private Calculator target;

    public CalculatorProxy() {
    }

    public CalculatorProxy(Calculator target) {
        this.target = target;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("[日志] add 方法开始了，参数是：" + a + "," + b);
        int result  = target.add(a,b);
        System.out.println("[日志] add 方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("[日志] sub 方法开始了，参数是：" + a + "," + b);
        int result  = target.sub(a,b);
        System.out.println("[日志] sub 方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public double div(int a, int b) throws Exception {
        System.out.println("[日志] mul 方法开始了，参数是：" + a + "," + b);
        double result  = target.div(a,b);
        System.out.println("[日志] mul 方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("[日志] div 方法开始了，参数是：" + a + "," + b);
        int result  = target.mul(a,b);
        System.out.println("[日志] div 方法结束了，结果是：" + result);
        return result;
    }
}
