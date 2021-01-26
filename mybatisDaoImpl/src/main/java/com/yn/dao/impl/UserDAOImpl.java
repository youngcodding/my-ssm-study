package com.yn.dao.impl;

import com.yn.dao.IUserDAO;
import com.yn.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/26-21:05
 */
public class UserDAOImpl implements IUserDAO {

    private SqlSessionFactory factory;

    public UserDAOImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.yn.dao.IUserDAO.findAll");
        session.close();
        return users;
    }
    @Override
    public User findById(Integer id) {
        SqlSession session = factory.openSession();
        User user= session.selectOne("com.yn.dao.IUserDAO.findById",id);
        session.close();
        return user;
    }
    @Override
    public int createUser(User user) {
        SqlSession session = factory.openSession();
        int result= session.insert("com.yn.dao.IUserDAO.createUser",user);
        session.commit();
        session.close();
        return result;
    }
    @Override
    public int updateUser(User user) {
        SqlSession session = factory.openSession();
        int result= session.update("com.yn.dao.IUserDAO.updateUser",user);
        session.commit();
        session.close();
        return result;
    }
    @Override
    public int deleteUser(Integer uid) {
        SqlSession session = factory.openSession();
        int result= session.update("com.yn.dao.IUserDAO.deleteUser",uid);
        session.commit();
        session.close();
        return result;
    }
    @Override
    public List<User> findByName(String name) {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.yn.dao.IUserDAO.findByName",name);
        session.close();
        return users;
    }
    @Override
    public int count() {
        SqlSession session = factory.openSession();
        int result = session.selectOne("com.yn.dao.IUserDAO.count");
        session.close();
        return result;
    }
}
