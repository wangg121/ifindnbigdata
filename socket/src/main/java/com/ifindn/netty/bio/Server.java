package com.ifindn.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Guo Yan
 * @date 2020/4/29-22:09
 */
public class Server {
    final static int PORT = 7777;

    public static void main(String[] args){
        ServerSocket server = null;

        try {
            server = new ServerSocket(PORT);
            System.out.println("服务端启动");
            Socket socket = server.accept();
            new Thread(new ServerHandler(socket)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
