package com.ifindn.exeutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Guo Yan
 * @date 2020/4/22-23:12
 */
public class Main {

    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(4);
    }

}
