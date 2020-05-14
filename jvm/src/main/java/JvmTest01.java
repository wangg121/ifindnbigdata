/**
 * @author Guo Yan
 * @date 2020/5/7-22:50
 * 
 */
public class JvmTest01 {
    
    public static void main(String[] args){

        System.out.println("max memory " + Runtime.getRuntime().maxMemory());
        System.out.println("free memory " + Runtime.getRuntime().freeMemory());
        System.out.println("total memory " + Runtime.getRuntime().totalMemory());

        byte[] b1 = new byte[1*1024*1024];
        System.out.println("分配了1M");

        System.out.println("max memory " + Runtime.getRuntime().maxMemory());
        System.out.println("free memory " + Runtime.getRuntime().freeMemory());
        System.out.println("total memory " + Runtime.getRuntime().totalMemory());


        byte[] b2 = new byte[4*1024*1024];
        System.out.println("分配了4M");

        System.out.println("max memory " + Runtime.getRuntime().maxMemory());
        System.out.println("free memory " + Runtime.getRuntime().freeMemory());
        System.out.println("total memory " + Runtime.getRuntime().totalMemory());


    }

}
