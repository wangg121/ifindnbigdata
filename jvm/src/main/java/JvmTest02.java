/**
 * @author Guo Yan
 * @date 2020/5/8-11:26
 * 设置新生代
 */
public class JvmTest02 {
    public static void main(String[] args){
        //第一次配置
        //-Xms20m -Xmx20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC

        //第二次配置
        //-Xms20m -Xmx20m -XX:NewRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC

        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[1024*1024];
        }
    }

}
