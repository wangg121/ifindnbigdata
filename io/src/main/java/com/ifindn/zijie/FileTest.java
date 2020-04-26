package com.ifindn.zijie;

import java.io.File;

/**
 * @author Guo Yan
 * @date 2020/4/14-18:42
 */
public class FileTest {
    public static void main(String[] args){
        File f = new File("F:\\a\\b\\c");


        if(f.isFile()){
            System.out.println(f + " 是一个文件");
        }

        System.out.println("上级是： " + f.getParent());

        System.out.println("上级文件是？ "  + f.getParentFile());

        System.out.println("目录为： " + f.getAbsolutePath());

        File newFile = new File("F:\\d.txt");

        System.out.println("更改名称： " + f.renameTo(newFile));


        File f2 = new File("F:\\a\\b\\c");


        File f3  = new File("F:\\【java自学网-javazx.com】尚硅谷视频打包地址（不对外）");

        String[] list = f3.list();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }

        System.out.println("-----------------------------------");

        File[] listFile = f3.listFiles();
        for (int i = 0; i < listFile.length; i++) {
            System.out.println(listFile[i].getName());
        }

        char c = 'a';
        System.out.println((byte) c);
    }
}
