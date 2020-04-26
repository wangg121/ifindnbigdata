package com.ifindn;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Guo Yan
 * @date 2020/4/16-14:21
 */
public class TestTcp {

    @Test
    public void test1() {
        Socket client = null;
        DataInputStream dis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String str = null;
        try {
            client = new Socket("127.0.0.1", 9090);
            OutputStream out = client.getOutputStream();
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true){
                System.out.println("请发送数据");
                if((str = br.readLine()) != null){

                    out.write(str.getBytes());
                    out.flush();
                }else if(str.equalsIgnoreCase("exit")){
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(9090);
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            byte[] b = new byte[1024];
            int len;
            while (true) {
                if((len = is.read(b)) != -1){
                    String str = new String(b, 0, len);

                    System.out.println(str);
                    out.write("nice to meet you ".getBytes());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);


        try{
            while (true){
                System.out.println("请输入数据");
                String str;
                if((str = br.readLine()) != null){
                    System.out.println(str);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
