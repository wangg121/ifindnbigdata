package com.ifindn.prototype;

/**
 * @Author Mr.Guo
 * @Date 2020-09-14 22:01
 */
public class ConcretePrototype extends Prototype {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
