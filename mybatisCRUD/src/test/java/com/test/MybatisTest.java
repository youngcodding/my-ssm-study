package com.test;

import com.yn.dao.IUserDAO;
import com.yn.entity.User;
import com.yn.vo.Query;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    private static SqlSession session ;
    private static  IUserDAO dao;

    @Before
    public void init() throws IOException {
        //1、读取mybatis主配置文件
       in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionFactory的构建对象
        SqlSessionFactoryBuilder  builder = new SqlSessionFactoryBuilder();
        //3、使用构建对象创建SqlSessionFactory
        SqlSessionFactory factory= builder.build(in);
        //4、使用SqlSessionFactory工厂创建SqlSession对象
       session = factory.openSession();
        //5、使用SqlSession创建dao接口的代理类对象
        dao = session.getMapper(IUserDAO.class);
    }

    @After
    public void destroy(){

        //加上手动提交事务
        session.commit();
        //释放资源
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        session.close();
    }
    @Test
    public void findAll() throws IOException {
        //6、使用代理类执行接口的查询方法
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
    /*
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
    */
   /* @Test
    public void updateUser(){
        User user = dao.findById(45);
        user.setUsername("ynynyn");
        int result = dao.updateUser(user);
        System.out.println(result);
    }
*/
    @Test
    public void deleteOne(){
        int result = dao.deleteUser(51);
        System.out.println(result);
    }

    @Test
    public void findByName(){
        List<User> users = dao.findByName("%王%");
        // List<User> users = dao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void count(){
        int count = dao.count();
        System.out.println(count);
    }

   /* @Test
    public void findByQueryVo(){
        Query query = new Query();
        User user = new User();
        user.setUsername("%王%");
        query.setUser(user);
        List<User> users = dao.findByVo(query);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
*/
}
