package com.ifindn.proxy.cglib;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author Mr.Guo
 * @Date 2020-08-04 23:45
 */
public class TestCglib {

    public static void main(String[] args) {
        MeiPo meiPo = new MeiPo();
        SingleMan man = (SingleMan) meiPo.getInstance(SingleMan.class);
        man.findLove();

    }
}
