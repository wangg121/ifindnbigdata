package com.ifindn.zijie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Guo Yan
 * @date 2020/4/15-9:59
 * 读取并写入文件，相当于复制
 */
public class InputOutputTest {
    public static void main(String[] args) {
        File inFile = new File("F:/aaa.jpg");
        File outFile = new File("F:/ccc.jpg");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(inFile);
            fos = new FileOutputStream(outFile);

            byte[] b = new byte[20];
            int len = 0;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
