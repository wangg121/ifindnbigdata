package com.ifindn;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Guo Yan
 * @date 2020/4/16-17:25
 */
public class TestUDP {

    @Test
    public void send(){
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            byte[] b = "你好，世界".getBytes();
            DatagramPacket packet = new DatagramPacket(b,0,b.length,
                    InetAddress.getByName("127.0.0.1"),9090);
            ds.send(packet);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ds.close();
        }
    }


    @Test
    public void revice(){
        DatagramSocket ds= null;
        try {
            ds = new DatagramSocket(9090);
            byte[] b = new byte[1024];
            DatagramPacket packet = new DatagramPacket(b,0,b.length);
            ds.receive(packet);
            String str = new String(packet.getData());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ds != null){
                ds.close();
            }
        }
    }

    @Test
    public void classLoader(){
        ClassLoader lo1 = this.getClass().getClassLoader();
        System.out.println(lo1);

        ClassLoader lo2 = lo1.getParent();
        System.out.println(lo1.getParent());

        ClassLoader lo3 = lo2.getParent();
        System.out.println(lo3);
    }


}
