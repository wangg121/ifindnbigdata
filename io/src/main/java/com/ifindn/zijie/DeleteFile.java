package com.ifindn.zijie;

import java.io.File;

/**
 * @author Guo Yan
 * @date 2020/4/15-10:42
 */
public class DeleteFile {
    public static void main(String[] args){
        File file1 = new File("./io");
        File[] files = file1.listFiles();

        for(File file : files){
            if(file.isFile()){
                System.out.println();
                String str = file.getName().split("\\.")[1];
                if (str.equals("jpg") || str.equals("rar") || str.equals("txt")) {
                    System.out.println(file.delete());
                }
            }
        }
    }

}
