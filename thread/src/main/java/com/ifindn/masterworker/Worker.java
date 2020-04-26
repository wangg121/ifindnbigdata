package com.ifindn.masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author Guo Yan
 * @date 2020/4/22-16:37
 */
public class Worker implements Runnable {

    private ConcurrentLinkedDeque<Task> taskQueue;
    private ConcurrentHashMap<String, Object> resultMap;

    public void setTaskQueue(ConcurrentLinkedDeque<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void setResultMap(ConcurrentHashMap resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while (true) {
            Task a = taskQueue.poll();

            if (a == null){
                break;
            }
            Object output = handle(a);
            resultMap.put(Integer.toString(a.getId()),output);
        }
    }

    private Object handle(Task task){
        Object output = null;
        output = task.getPrice();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }
}
