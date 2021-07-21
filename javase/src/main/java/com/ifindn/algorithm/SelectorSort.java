package com.ifindn.algorithm;

/**
 * 选择排序，不推荐使用，不稳定
 * 不稳定，当数组中存在两个相同的元素时，相同元素的值会变化
 */
public class SelectorSort {

    public static void main(String[] args) {
        int[] array = {9,5,4,3,6,1,8};

        for (int i = 0; i < array.length - 1; i++) {
            int minPos = i;
            for(int k = i + 1;k < array.length;k++){
                minPos = array[k] < array[minPos] ? k : minPos;
            }

            MyUtils.swap(array,i,minPos);

            System.out.println("进行第" + i + "次遍历，数组内容");
            MyUtils.printArray(array);
        }


    }

    public static void sort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int minPos = i;
            for(int k = i + 1;k < array.length;k++){
                minPos = array[k] < array[minPos] ? k : minPos;
            }

            MyUtils.swap(array,i,minPos);

//            System.out.println("进行第" + i + "次遍历，数组内容");
//            printArray(array);
        }
    }


}
