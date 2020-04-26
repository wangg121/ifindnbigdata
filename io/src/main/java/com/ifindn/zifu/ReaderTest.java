package com.ifindn.zifu;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Guo Yan
 * @date 2020/4/15-11:12
 */
public class ReaderTest {
    public static void main(String[] args) {
        File file = new File("F:\\A.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] c = new char[100];
            int len;
            while ((len = fr.read(c)) != -1) {
                String str = new String(c, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
