package com.yn.dao;

import com.yn.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/20-20:53
 */
public interface IUserDAO {
    /**
     * 查找所有的操作
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();
}
