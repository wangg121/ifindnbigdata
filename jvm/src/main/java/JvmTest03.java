import java.util.ArrayList;
import java.util.List;

/**
 * @author Guo Yan
 * @date 2020/5/8-13:58
 * jdk1.8改成元空间
 */
public class JvmTest03 {
    static String base = "string";
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String string = base + base;
            base = string;
            list.add(string.intern());
        }
    }
}
