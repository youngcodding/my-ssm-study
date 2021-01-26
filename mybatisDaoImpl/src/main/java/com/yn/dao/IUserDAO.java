package com.yn.dao;

import com.yn.entity.User;

import java.util.List;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/26-15:24
 */
public interface IUserDAO {


    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 根据id查询单个用户
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 增加用户
     * @param user
     * @return
     */
    public int createUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 删除用户信息
     * @param uid
     * @return
     */
    public int deleteUser(Integer uid);

    /**
     * 根据名称模糊查询
     * @param name
     * @return
     */
    public List<User> findByName(String name);

    /**
     * 查询总记录数
     * @return
     */
    public int count();
}
