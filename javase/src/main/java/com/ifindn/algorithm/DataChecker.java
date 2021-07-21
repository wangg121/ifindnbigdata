package com.ifindn.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 检查算法是否正确
 */
public class DataChecker {

    public static void main(String[] args) {
        int[] array = generateRandomData();
        check(array);
    }

    public static void check(int[] src){
        int[] copyArray = new int[src.length];
        System.arraycopy(src,0,copyArray,0,src.length);
        Arrays.sort(src);
        SelectorSort.sort(copyArray);

        boolean check = true;
        for(int i = 0;i<src.length;i++) {
            if(src[i] != copyArray[i]){
                check = false;
            }
        }

        System.out.println(check == true? "right":"false");
    }

    public static int[] generateRandomData(){
        int[] array = new int[10000];

        Random random = new Random();

        for(int i = 0;i<array.length;i++){
            array[i] = random.nextInt();
        }

        return array;
    }
}
