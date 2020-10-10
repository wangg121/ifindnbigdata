package com.ifindn.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mr.Guo
 * @Date 2020-09-14 23:05
 */
public class TestMain {

    public static void main(String[] args) {

        long start1 = System.currentTimeMillis();
        List<JSONObject> jsonList = new ArrayList<>();
        for(int i = 0;i<10000;i++){
            JSONObject obj = new JSONObject();
            obj.put("age",12);
            obj.put("name","zhangsan");
            jsonList.add(obj);
        }
        System.out.println("jsonobject耗时" + (System.currentTimeMillis()-start1));

        long start2 = System.currentTimeMillis();
        List<Student> students = new ArrayList<>();
        for(int i = 0;i<10000;i++){
            Student st = new Student();
            st.setAge(12);
            st.setName("张三");
            students.add(st);
        }
        System.out.println("student耗时" + (System.currentTimeMillis()-start2));

        System.out.println("--------------------------------");
        long start3 = System.currentTimeMillis();
        for(JSONObject jsonObject:jsonList){
            String name = jsonObject.getString("name");
        }
        System.out.println("遍历jsonlist耗时：" + (System.currentTimeMillis()-start3));


        long start4 = System.currentTimeMillis();
        for(Student jsonObject:students){
            String name = jsonObject.getName();
        }
        System.out.println("遍历students耗时：" + (System.currentTimeMillis()-start4));
    }
}
