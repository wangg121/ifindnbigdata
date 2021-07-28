package com.ifindn.algorithm;

/**
 * 斐波那契数列：https://blog.csdn.net/weixin_30649293/article/details/114096420?utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
 */
public class 台阶步数问题 {

    public static void main(String[] args) {

        System.out.println(cal1(10));
        System.out.println(cal2(10));
    }

    /**
     *使用递归方法，从上往下推，f(n) = f(n-1) + f(n-2)需要递归n次，时间复杂度很高为2的n次方
     */
    public static int cal1(int num){
        if(num <= 2){
            return num;
        }

        return cal1(num-1) + cal1(num -2);
    }

    /**
     * 从下往上推，前两个数加和为后一个数值
     */
    public static int cal2(int num){

        if(num <= 2){
            return num;
        }

        int a = 1;
        int b = 2;

        int result = 0;

        for(int i = 3;i<=num;i++){
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }
}
