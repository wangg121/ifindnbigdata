package com.ifindn;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Guo Yan
 * @date 2020/4/15-23:11
 */
public class TestRandomAccessFile {

    /**
     * 在c后追加xy
     */
    @Test
    public void test1(){
        RandomAccessFile read = null;
        try {
            read = new RandomAccessFile("./a.txt", "rw");

            read.seek(3);
            byte[] b = new byte[20];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = read.read(b)) != -1){
                sb.append(new String(b,0,len));
            }
            read.seek(3);
            read.write("xy".getBytes());
            read.write(sb.toString().getBytes());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(read != null){
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Test
    public void test2(){
        RandomAccessFile read = null;
        RandomAccessFile write = null;
        try {
            read = new RandomAccessFile("./a.txt", "r");
            write = new RandomAccessFile("./a1.txt", "rw");

            byte[] b = new byte[20];
            int len;
            while ((len = read.read(b)) != -1){
                write.write(b,0,len);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(read != null){
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(write != null){
                try {
                    write.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
