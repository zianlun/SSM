package zian.example.aopXml;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/27/15:59
 * @Description:
 */
public interface Calculator {

    int add(int a, int b);

    int sub(int a, int b);

    double div(int a, int b) throws Exception;

    int mul(int a, int b);
}
