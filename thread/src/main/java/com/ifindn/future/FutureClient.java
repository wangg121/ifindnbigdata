package com.ifindn.future;

/**
 * @author Guo Yan
 * @date 2020/4/22-10:16
 */
public class FutureClient {


    public FutureData request(String queryStr){
        FutureData data = new FutureData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("进入线程");
                RealData realData = new RealData();
                data.setRealData(realData);
            }
        }).start();

        return  data;
    }



}
