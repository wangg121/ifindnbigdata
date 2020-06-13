package com.ifindn.mybatis;

import com.ifindn.controller.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author Guo Yan
 * @date 2020/6/5-15:03
 */
public class TestMabtis {

    private SqlSession session;

    private String statement;

    @Before
    public void init() {
        String resource = "mybatis-conf.xml";
        InputStream is = TestMabtis.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        session = factory.openSession(true);
    }

    @Test
    public void insert() {
        Users adduser = new Users(-1, "jerry", 20);
        statement = "com.ifindn.mybatis.usersMapper.addUser";
        System.out.println(session.insert(statement, adduser));
    }

    @Test
    public void delete(){
        statement =  "com.ifindn.mybatis.usersMapper.deleteUser";
        session.delete(statement,6);
    }

    @Test
    public void update(){
        statement = "com.ifindn.mybatis.usersMapper.updateUser";
        session.update(statement,new Users(1,"zhangsan",12));
    }

    @Test
    public void getAll(){
        statement = "com.ifindn.mybatis.usersMapper.getAll";
        List<User> list = session.selectList(statement);
        System.out.println(list);
    }

    @Test
    public void addUserByAnnotation(){
        UsersMapperInerface mapper = session.getMapper(UsersMapperInerface.class);
        mapper.addUser(new Users(-1,"lisi",20));
    }

    @Test
    public void getUserByName(){
        statement = "com.ifindn.mybatis.usersMapper.getUserByName";
        List<Users> list = session.selectList(statement,"j");
        for(Users u :list){
            System.out.println(u);
        }
    }

    @After
    public void close() {
        session.close();
    }


}
