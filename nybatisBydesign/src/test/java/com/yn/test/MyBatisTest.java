package com.yn.test;

import com.yn.dao.IUserDAO;
import com.yn.domain.User;
import com.yn.mybatis.io.Resources;
import com.yn.mybatis.session.SqlSession;
import com.yn.mybatis.session.SqlSessionFactory;
import com.yn.mybatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/20-21:22
 */
public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        //1、读取mybatis主配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionFactory的构建对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3、使用构建对象创建SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
        //4、使用SqlSessionFactory工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //5、使用SqlSession创建dao接口的代理类对象
        IUserDAO dao = session.getMapper(IUserDAO.class);
        //6、使用代理类执行接口的查询方法
        List<User> userList = dao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
