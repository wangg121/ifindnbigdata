package com.ifindn;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Guo Yan
 * @date 2020/4/16-10:09
 * 获取ip地址
 */
public class TestInetAddress {
    public static void main(String[] args){
        try {
            InetAddress a = InetAddress.getByName("61.135.169.121");
            System.out.println(a.getAddress());
            System.out.println(a.getHostAddress());
            System.out.println(a.getHostName());

            InetAddress local = InetAddress.getLocalHost();
            System.out.println(local.getHostName());
            System.out.println(local.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
