package com.ifindn.zijie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Guo Yan
 * @date 2020/4/15-9:33
 */
public class FileOutputTest {
    public static void main(String[] args){
        File file = new File("./io/hello2.txt");
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            fos.write(new String("i love china").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
