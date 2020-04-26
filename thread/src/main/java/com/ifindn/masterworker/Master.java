package com.ifindn.masterworker;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author Guo Yan
 * @date 2020/4/22-16:37
 */
public class Master {

    private  ConcurrentLinkedDeque<Task> taskQueue = new ConcurrentLinkedDeque<>();

    //worker组
    private HashMap<String,Thread> workers = new HashMap<>();

    //结果集
    private ConcurrentHashMap<String,Object> resultMap = new ConcurrentHashMap<>();


    public Master(Worker worker,int workCount){
        worker.setTaskQueue(taskQueue);
        worker.setResultMap(resultMap);
        for (int i = 0; i < workCount ; i++) {
            workers.put(Integer.toString(i),new Thread(worker));
        }
    }

    public void submit(Task task){
        this.taskQueue.add(task);
    }

    public void execute(){
        for(Thread thread:workers.values()){
            thread.start();
        }
    }

    public boolean isComplete(){
        boolean b = false;
        for(Thread thread : workers.values()){
            if(thread.getState().equals(Thread.State.TERMINATED)){
                b = true;
            }
        }
        return  b;
    }

    public Integer getResult(){
        int result = 0;
        for(Object obj:resultMap.values()){
            int num = (int)obj;
            result +=num;
        }

        return result;
    }


}
