package com.ifindn.future;

/**
 * @author Guo Yan
 * @date 2020/4/22-10:09
 */
public class FutureData implements Data {

    private RealData realData;

    private boolean ready = false;


    public synchronized void setRealData(RealData realData){

        //如果已经加载完毕，就直接返回
        if(ready){
            return;
        }

        this.realData = realData;
        ready = true;
        notify();

    }


    @Override
    public synchronized  String getRequest() {
        while (!ready){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return  realData.getRequest();
    }
}
