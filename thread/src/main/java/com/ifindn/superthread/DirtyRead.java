package com.ifindn.superthread;

import java.util.HashMap;

/**
 * @author Guo Yan
 * @date 2020/4/17-18:01
 * 脏读
 */
public class DirtyRead {

    private String useranme = "zhangsan";

    private String password = "123";

    public synchronized  void setValue(String useranme,String password){

        this.useranme = useranme;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        this.password = password;

        System.out.println("setVlue的最终结果：username = " + useranme);
    }

    public synchronized  void getValue(){

        System.out.println("getValue方法得到 username = " + useranme );

    }
    
    
    
    public static void main(String[] args) throws InterruptedException {
        DirtyRead dirtyRead = new DirtyRead();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                dirtyRead.setValue("xiaohong","23");
            }
        });

        t.start();

//        Thread.sleep(1000);

        dirtyRead.getValue();

        HashMap<String, Integer> S = new HashMap<>(1, 0.2F);

        S.put("key",1);
        System.out.println(S.put("key",2));
        System.out.println(S.get(null));
    }
}
