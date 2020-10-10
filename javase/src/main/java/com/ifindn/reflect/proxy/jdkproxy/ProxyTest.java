package com.ifindn.reflect.proxy.jdkproxy;

/**
 * @Author Mr.Guo
 * @Date 2020-06-30 11:13
 */
public class ProxyTest {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);
        SubjectProxy proxy = new SubjectProxy(new SubjectImpl());
        Subject subject = (Subject)proxy.getSubjectProxy();
        subject.sayHi("张三");
        subject.sayBye("张三");

        int a = 1|4;
        System.out.println(a);





    }
}
