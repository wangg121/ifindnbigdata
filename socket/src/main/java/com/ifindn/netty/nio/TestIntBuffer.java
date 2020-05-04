package com.ifindn.netty.nio;

import java.nio.IntBuffer;

/**
 * @author Guo Yan
 * @date 2020/5/1-9:03
 *
 */
public class TestIntBuffer {

    public static void main(String[] args){

        //1.基本操作
/*
        IntBuffer ib = IntBuffer.allocate(10);
        //填充完数据后，position位置会自动向后偏移一位
        ib.put(100);//position位置：0》1
        ib.put(200);//position位置：1》2
        ib.put(300);//position位置：2》3

        //把位置复位为0，也就是position的位置从3》0，此时limit的值也会重置
//        ib.flip();

        System.out.println("使用flip复位：" + ib);
        System.out.println("容量为：" + ib.capacity());//容量一旦初始化后不允许改变，（warp方法包裹数组除外）
        System.out.println("限制为：" + ib.limit());//由于只填充了三个元素，所以可读取或可操作的元素为3，则limit=3

        System.out.println("获取下标为1的元素：" + ib.get(1));
        System.out.println("get(index)方法：position位置不变 " + ib);

        ib.put(1,500);
        System.out.println("put(index,change)方法，position位置不变");

        System.out.println("调用get（）方法");
        for (int i = 0; i < ib.limit() ; i++) {
            System.out.print(ib.get() + "\t");
        }
        System.out.println();

        System.out.println("ib对象遍历之后为：" + ib);*/


        //2.warp方法
        /*warp方法会包裹一个数组，一般这种用法不会先初始化对象的长度，因为没有意义，最后还会被warp所包裹的数组覆盖掉
        * */
        int[] arr = new int[]{1,2,3};
        IntBuffer ib1  = IntBuffer.wrap(arr);
        System.out.println(ib1);

        IntBuffer ib2 = IntBuffer.wrap(arr,0,2);
        //这样使用表示容量为数组arr的长度，但是可操作的元素只有实际进入缓存区的元素长度

    }

}
