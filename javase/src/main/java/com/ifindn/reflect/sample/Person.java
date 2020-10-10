package com.ifindn.reflect.sample;

/**
 * @Author Mr.Guo
 * @Date 2020-06-29 21:54
 */
public class Person {

    private String name;
    private int age;

    public Person() {
        System.out.println("execute 无参构造器");
    }

    public Person(String name) {
        System.out.println("execute name 构造器");
        this.name = name;
    }

    public Person(int age) {
        System.out.println("execute age 构造器");
        this.age = age;
    }

    public Person(String name, int age) {
        System.out.println("execute name + age 构造器");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
