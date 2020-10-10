package com.ifindn.threadlocal;

import java.util.Random;

/**
 * @Author Mr.Guo
 * @Date 2020-07-01 23:13
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        Random random = new Random();

        float a = 1.01f;
        float num = 1;
        for(int i = 0;i<250 ;i++){
            num =num * a;
        }
        System.out.println(num);


        for (int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int a = random.nextInt();
                    
                }
            });
        }
    }
}
