package com.ifindn.algorithm;

/**
 * 冒泡排序，基本不用，太慢
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {9,3,2,4,8,1,6};
        sort(array);
    }

    public static void sort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int max = array[i];
            for (int k = i+1;k<array.length;k++){
                if(max > array[k]){
                    max = array[k];
                    MyUtils.swap(array,i,k);
                }
            }
        }

        MyUtils.printArray(array);


    }

    //计算两个坐标点之间的距离，单位米
    public static double calculateDistance(double lng1,double lat1,double lng2,double lat2){
        double a, b;
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        a = lat1 - lat2;
        b = (lng1 - lng2) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2 * 6371393 * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
        return d;
    }
}
