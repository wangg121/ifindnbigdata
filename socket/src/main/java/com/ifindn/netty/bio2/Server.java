package com.ifindn.netty.bio2;

import com.ifindn.netty.bio.ServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Guo Yan
 * @date 2020/4/30-10:59
 */
public class Server {


    private static final int PORT = 7777;

    public static void main(String[] args){
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(PORT);
            HandlerExecutorPool pool = new HandlerExecutorPool(50,1000);
            while (true){
                socket = server.accept();
                ServerHandler task = new ServerHandler(socket);
                pool.execute(task);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != socket){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
