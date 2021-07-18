package com.ifindn.annotation.myjunit.test;

import com.ifindn.annotation.myjunit.selfAnnotation.MyAfter;
import com.ifindn.annotation.myjunit.selfAnnotation.MyBefore;
import com.ifindn.annotation.myjunit.selfAnnotation.MyTest;

/**
 * 测试类，使用注解
 */
public class EmployeeDaoTest {


    @MyBefore
    public void  init(){
        System.out.println("初始化....");
    }


    @MyAfter
    public void destroy(){
        System.out.println("销毁....");
    }


    @MyTest
    public void test1(){
        System.out.println("测试用例1执行....");
    }

    @MyTest
    public void test2(){
        System.out.println("测试用例2执行....");
    }
}
