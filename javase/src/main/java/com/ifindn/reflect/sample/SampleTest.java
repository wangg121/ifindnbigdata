package com.ifindn.reflect.sample;

import java.lang.reflect.*;

/**
 * @Author Mr.Guo
 * @Date 2020-06-29 21:55
 *
 * 反射的基本应用
 */
public class SampleTest {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("com.ifindn.reflect.sample.Person");

        //通过无参构造
        Person person = (Person) clazz.newInstance();

        Constructor[] constructors = clazz.getConstructors();


        //获取构造器
//        for(Constructor c : constructors){
//            Class[] types = c.getParameterTypes();
//            for(Class type :types){
//                System.out.print("构造器参数类型" + type.getName());
//            }
//            System.out.println();
//            if (types.length == 1 && types[0].getSimpleName().equals("String")){
//                System.out.println("通过构造器实例化对象 " +  c.newInstance("张三"));
//            }
//
//        }

        //获取类的属性
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field field:fields){
//            System.out.println("字段名称为" + field.getName());
//            if(field.getName().equals("name")){
//                field.setAccessible(true);
//                field.set(person,"lisi");
//            }
//        }
//        System.out.println(person);
        //方法
//        Method[] methods = clazz.getMethods();
//        for(Method method:methods){
//            String methodName = method.getName();
//            StringBuilder str = new StringBuilder();
//            str.append(methodName).append("方法参数为 ");
//            for(Class parameter:method.getParameterTypes()){
//               str.append(parameter.getSimpleName());
//            }
//            System.out.println(str);
//
//            System.out.println("方法返回值 " + method.getReturnType());
//        }




    }
}
