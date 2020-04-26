package com.ifindn.masterworker;

/**
 * @author Guo Yan
 * @date 2020/4/22-17:11
 */
public class Main {
    
    public static void main(String[] args){
        Worker worker = new Worker();
        Master master = new Master(worker,20);

        for (int i = 0; i <100 ; i++) {
            Task a = new Task();
            a.setId(i);
            a.setPrice(i);
            master.submit(a);
        }


        master.execute();
        long start = System.currentTimeMillis();

        while (true){
            if(master.isComplete()){
                long end = System.currentTimeMillis();
                int result = master.getResult();
                System.out.println("结果为：" + result + "共耗时：" + (end - start));
                break;
            }
        }






    }

}
