import org.testng.annotations.Test;

import java.util.*;

/**
 * @author Guo Yan
 * @date 2020/6/8-11:29
 */
public class Main {


    @Test
    public void test1(){

        Set<String> set = new TreeSet<>();
        set.add("zhangsan");
        set.add("lisi");
        set.add("wangwu");
        set.add("zhaoliu");
        System.out.println(set);



    }


    public static void num(int n ){
        Map<String,String> a = new HashMap<>();
        a.put(null,null);
        System.out.println(a);
    }

}
