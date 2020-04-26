package com.ifindn.zijie;

import java.io.*;

/**
 * @author Guo Yan
 * @date 2020/4/15-12:49
 */
public class BufferReaderTest {

    public static void main(String[] args){
        File file1 = new File("F:\\aaa.rar");
        System.out.println(file1.exists());
        File file2 = new File("F:\\asd.rar");

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        long start = System.currentTimeMillis();

        try{
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1){
                bos.write(b,0,len);
                bos.flush();
            }

            long end = System.currentTimeMillis();
            System.out.println("好费时间：" + (end - start));

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
