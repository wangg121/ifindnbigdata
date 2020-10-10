package com.ifindn.provider;

import com.ifindn.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mr.Guo
 * @Date 2020-06-22 20:19
 */
public class SamplerServiceImpl implements SamplerService {
    @Override
    public String sayHello(String name) {
        System.out.println("hello" + name);
        return "hello" + name;
    }

    @Override
    public List getUsers() {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setName("jack");
        user1.setAge(12);
        user1.setSex("F");

        User user2 = new User();
        user1.setName("rose");
        user1.setAge(13);
        user1.setSex("M");

        User user3 = new User();
        user1.setName("liming");
        user1.setAge(12);
        user1.setSex("F");

        list.add(user1);
        list.add(user2);
        list.add(user3);

        return list;
    }
}
