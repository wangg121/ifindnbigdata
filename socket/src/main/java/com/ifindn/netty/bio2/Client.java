package com.ifindn.netty.bio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Guo Yan
 * @date 2020/4/30-11:21
 */
public class Client {

    private static final int PORT = 7777;
    private static final String ADDRESS = "127.0.0.1";

    public static void main(String[] args){

        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            socket = new Socket(ADDRESS,PORT);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(),true);

            pw.println("开始给服务端发送数据");

            char[] chars = new char[100];
            int len;
            while ((len = br.read(chars)) != -1){
                String str = new String(chars,0,len);
                System.out.println("client接收 " +str);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
