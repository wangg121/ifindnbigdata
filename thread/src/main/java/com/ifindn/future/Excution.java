package com.ifindn.future;

/**
 * @author Guo Yan
 * @date 2020/4/22-10:25
 */
public class Excution {

    public static void main(String[] args){
        FutureClient client = new FutureClient();
        FutureData data = client.request("query");

        System.out.println("发送请求");

        System.out.println("做其他事情");

        String result = data.getRequest();

        System.out.println(result);
    }

}
