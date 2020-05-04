package com.ifindn.netty.bio;

import java.io.*;
import java.net.Socket;

/**
 * @author Guo Yan
 * @date 2020/4/29-22:16
 */
public class Client {

    private final static String IP = "127.0.0.1";

    private final static int PORT = 7777;

    public static void main(String[] args){
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            socket = new Socket(IP,PORT);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(),true);
            //在另一端如果用readLine()方法。由于读不到换行符，意味中读不到结束标记，
            // 然后由于IO流是阻塞式的，所以程序就是一直卡在那里不动了。原因即为缺少回车标识。
            // 如果在写入的时候加上“\r\n”,就可以解决这个问题了。而println()就自动加上了换行符了。
            pw.println("接收到客户端的请求");
            pw.flush();
//            String msg = br.readLine();
            int len;
            char[] c = new char[100];
            while ((len =br.read(c))!=-1){
                String msg = new String(c,0,len);
                System.out.println("clinet " + msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }

}
