package com.ifindn.superthread;

import java.util.concurrent.DelayQueue;

/**
 * @author Guo Yan
 * @date 2020/4/21-15:42
 * DelayQueue带有延迟时间queue，其中的元素只有当指定的延迟时间到了，才能从队列中获取到
 * 该元素。
 */
public class WangBa implements Runnable {

    private DelayQueue<WangMin> delay = new DelayQueue<WangMin>();

    public boolean yingye = true;

    public void shangji(String name ,String id ,int money){

        WangMin w = new WangMin(name,id,money * 1000 + System.currentTimeMillis());
        System.out.println("网名" + w.getName() + "id " + w.getId() + "交钱 " + money + "块，开始上机");
        delay.add(w);
    }

    public void xiaji(WangMin wangMin){
        System.out.println("网名 " + wangMin.getName() + "下机");
    }


    @Override
    public void run() {
        while (true){
            try {
                WangMin w = delay.take();
                xiaji(w);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        WangBa wangba = new WangBa();
        Thread t = new Thread(wangba);
        t.start();

        wangba.shangji("zhangsan","123",2);
        wangba.shangji("lisi","456" ,5);
        wangba.shangji("wangwu","789" ,10);
    }
}
