package com.ifindn.serializable;

import org.junit.Test;

import java.io.*;

/**
 * @author Guo Yan
 * @date 2020/4/15-22:23
 */
public class OjbectOutputStreamTest {

    @Test
    public void ObjectInput(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("./object.txt"));

            Person p = (Person) ois.readObject();

            System.out.println(p);

        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void ObjectOut(){

        Person p = new Person("zhangsan",12);

        ObjectOutputStream oos = null;
        try {
             oos = new ObjectOutputStream(
                    new FileOutputStream("./object.txt"));
             oos.writeObject(p);
             oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class Person implements Serializable {
    private static final long serialVersionUID = 2423423423423434L;
    String name;
    int age;

    Person(String name,int age){
        this.name = name;
        this.age = age;

    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
