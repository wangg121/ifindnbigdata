package com.ifindn.netty.bio;

import java.io.*;
import java.net.Socket;

/**
 * @author Guo Yan
 * @date 2020/4/29-22:12
 */
public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;

        String msg = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            while (true) {
                msg = br.readLine();
                if (null == msg) {
                    break;
                }
                System.out.println("server：" + msg);
                pw.print("server发送的消息");
                pw.flush();
            }
            } catch(IOException e){
                e.printStackTrace();
            }finally {
            pw.close();
        }
        }
    }
