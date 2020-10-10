package com.ifindn.prototype;

/**
 * @Author Mr.Guo
 * @Date 2020-09-14 21:59
 */
public class Prototype implements Cloneable {

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
