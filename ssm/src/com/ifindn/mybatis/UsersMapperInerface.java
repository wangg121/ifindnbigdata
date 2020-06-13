package com.ifindn.mybatis;

import org.apache.ibatis.annotations.Insert;

/**
 * @author Guo Yan
 * @date 2020/6/5-16:35
 */
public interface UsersMapperInerface {

    @Insert("insert into users (name,age) values (#{name},#{age})")
    int addUser(Users user);
}
