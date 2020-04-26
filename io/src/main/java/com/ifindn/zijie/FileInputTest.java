package com.ifindn.zijie;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Guo Yan
 * @date 2020/4/14-23:27
 */
public class FileInputTest {

    public static void main(String[] args){

        File file = new File("F:\\A.txt");
        FileInputStream input = null;
        try {
            input = new FileInputStream(file);
            byte[] b = new byte[20];
            int len;
            while ((len = input.read(b)) != -1){
                String str = new String(b,0,len);
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
