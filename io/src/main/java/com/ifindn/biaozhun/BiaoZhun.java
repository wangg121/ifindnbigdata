package com.ifindn.biaozhun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Guo Yan
 * @date 2020/4/15-14:52
 * <p>
 * 标准输入输出流
 */
public class BiaoZhun {
    public static void main(String[] args) {
        InputStream is = System.in;

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        try {
            while (true) {
                System.out.println("请输入字符");
                String str;
                if ((str = br.readLine()) != null) {
                    if (str.equalsIgnoreCase("e") ||
                            str.equalsIgnoreCase("exit")) {
                        break;
                    }else{
                        System.out.println(str.toUpperCase());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
