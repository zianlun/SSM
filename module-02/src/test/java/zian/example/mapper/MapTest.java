package zian.example.mapper;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/23/9:42
 * @Description:
 */
public class MapTest {
    /***
    * @Description:通配符map的测试
    * @Author: ljzhang
    * @Date: 2023/2/23
    */
    @Test
    public void test1(){
        List<? extends Object> list1= new ArrayList<String>();
        List<? extends Object> list2= new ArrayList<Number>();
        List<? extends Object> list3= new ArrayList<Object>();
        //list1.add("ljzhang");
        //list2.add(Integer.parseInt(1));
        //list3.add("ljzhang");
        //list3.add(null);
    }
}
