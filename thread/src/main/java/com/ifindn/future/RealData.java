package com.ifindn.future;

/**
 * @author Guo Yan
 * @date 2020/4/22-10:09
 */
public class RealData implements Data {

    @Override
    public String getRequest() {
        System.out.println("this is a hardly work");

        return "query result";
    }
}
