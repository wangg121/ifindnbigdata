package com.ifindn.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author Guo Yan
 * @date 2020/6/9-17:08
 */
public class Main {



    static Random random = new Random();

    static long randomNum(){
        return  random.nextInt(10000);
    }

    public static void main(String[] args){
        Long[] array = new Long[20000];
        Long statTime1 = System.currentTimeMillis();
        long sum1 = 0;
        for(int i = 0;i<array.length;i++){
            array[i] = randomNum();
            sum1 += array[i];
        }
        Long endTime1 = System.currentTimeMillis();
        System.out.println("结果为 ：" + sum1 + " 时间为 ：" + (endTime1-statTime1));


        ForkJoinTask<Long> task = new SumTask(0,array.length,array);
        Long statTime2 = System.currentTimeMillis();
        long sum2 = ForkJoinPool.commonPool().invoke(task);
        Long endTime2= System.currentTimeMillis();
        System.out.println("结果为 ：" + sum2 + " 时间为 ：" + (endTime2-statTime2));

    }

}
