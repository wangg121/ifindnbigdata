package com.ifindn.annotation.myjunit.test;

import com.ifindn.annotation.myjunit.selfAnnotation.MyAfter;
import com.ifindn.annotation.myjunit.selfAnnotation.MyBefore;
import com.ifindn.annotation.myjunit.selfAnnotation.MyTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟junit的运行，
 * 获取注解并执行
 */
public class MyJunitFrameWork {

    public static void main(String[] args) {


        //1、获取要执行的测试类
        Class clazz = EmployeeDaoTest.class;

        //2、获取所有的公共方法
        Method[] methods = clazz.getMethods();

        try {

            //3、迭代出每一个method对象，判断哪些方法上使用了MyBefore，MyTest，MyAfter注解
            List<Method> beforeList = new ArrayList<>();
            List<Method> testList = new ArrayList<>();
            List<Method> afterList = new ArrayList<>();
            //isAnnotationPresent，如果指定的注解存在此元素上，返回true，否则返回false
            for (Method method : methods) {

                if (method.isAnnotationPresent(MyBefore.class)) {
                    //存储使用了MyBefore注解的方法对象
                    beforeList.add(method);
                } else if (method.isAnnotationPresent(MyTest.class)) {
                    //存储使用了MyTest注解的方法对象
                    testList.add(method);
                } else if (method.isAnnotationPresent(MyAfter.class)) {
                    //存储使用了MyAfter注解的方法对象
                    afterList.add(method);
                }
            }


            Object o = clazz.newInstance();

            //执行测试方法
            for (Method test : testList) {

                //先执行@MyBefore的方法
                for (Method before : beforeList) {
                    before.invoke(o);
                }

                //测试方法
                test.invoke(o);

                //最后执行@MyAfter的方法
                for (Method after : afterList) {
                    after.invoke(o);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
