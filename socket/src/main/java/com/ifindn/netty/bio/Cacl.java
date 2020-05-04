package com.ifindn.netty.bio;

/**
 * @author Guo Yan
 * @date 2020/4/30-16:35
 */
public class Cacl {

    public static void main(String[] args){
        int sum = 0;
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < i ; j++) {
                sum += (i + j);

                System.out.println("i:" + i + " j:" + j + " sum:" + sum);
            }

        }
        System.out.println(sum);
    }

}
