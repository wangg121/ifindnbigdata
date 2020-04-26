package com.ifindn.threadpool;

/**
 * @author Guo Yan
 * @date 2020/4/23-11:38
 */
public class MyTask implements Runnable {

    private String id;

    private String name;

    public MyTask(String id,String name){
           this.id = id;
           this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(this.name + "线程执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return this.id;
    }
}
