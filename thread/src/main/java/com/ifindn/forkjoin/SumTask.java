package com.ifindn.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author Guo Yan
 * @date 2020/6/9-16:52
 */
public class SumTask extends RecursiveTask<Long> {

    public static final int THRESHOLD = 500;

    int start;
    int end;

    Long[] array;

    public SumTask(int start, int end, Long[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    protected Long compute() {

        if(end - start < THRESHOLD){
            long sum = 0;
            for(int k = start; k <end; k++){
                sum +=array[k];
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return sum;
        }

        int middle = (start + end)/2;
        // “分裂”子任务:
        SumTask sumTask1 = new SumTask(start,middle,this.array);
        SumTask sumTask2 = new SumTask(middle,end,this.array);
        // invokeAll会并行运行两个子任务:
        sumTask1.fork();
        sumTask2.fork();
        // 获得子任务的结果:
        Long sum1 = sumTask1.join();
        Long sum2 = sumTask2.join();
        Long result = sum1 + sum2;


        return result;
    }
}
