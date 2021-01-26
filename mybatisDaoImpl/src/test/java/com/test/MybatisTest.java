package com.test;

import com.yn.dao.IUserDAO;
import com.yn.dao.impl.UserDAOImpl;
import com.yn.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.management.Query;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/26-15:26
 */
public class MybatisTest {
    private static InputStream in;
    private static  IUserDAO dao;

    @Before
    public void init() throws IOException {
        //1、读取mybatis主配置文件
       in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionFactory的构建对象
        SqlSessionFactoryBuilder  builder = new SqlSessionFactoryBuilder();
        //3、使用构建对象创建SqlSessionFactory
        SqlSessionFactory factory= builder.build(in);
        dao =new UserDAOImpl(factory);
    }

    @After
    public void destroy(){
        //释放资源
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findAll() throws IOException {
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findOne(){
        User u = dao.findById(46);
        System.out.println(u);

    }
        @Test
        public void createUser(){
            User user = new User();
            user.setUsername("mybatis insert  ");
            user.setSex("男");
            user.setAddress("武汉市江夏区");
            user.setBirthday(new Date());
            System.out.println("保存之前的user:"+user);
            int result = dao.createUser(user);
            System.out.println("保存之后的user:"+user);
            System.out.println(result);
        }

    @Test
    public void updateUser(){
        User user = dao.findById(45);
        user.setUsername("mmmm");
        int result = dao.updateUser(user);
        System.out.println(result);
    }
    @Test
    public void deleteOne(){
        int result = dao.deleteUser(55);
        System.out.println(result);
    }

    @Test
    public void findByName(){
        List<User> users = dao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void count(){
        int count = dao.count();
        System.out.println(count);
    }

}
