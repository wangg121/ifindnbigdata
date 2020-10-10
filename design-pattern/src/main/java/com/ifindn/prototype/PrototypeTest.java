package com.ifindn.prototype;

/**
 * @Author Mr.Guo
 * @Date 2020-09-14 22:02
 */
public class PrototypeTest {

    public static void main(String[] args) {
        ConcretePrototype cp = new ConcretePrototype();
        cp.setAge(18);

        try {
            ConcretePrototype cp2 = (ConcretePrototype) cp.clone();
            System.out.println(cp2.getAge());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
