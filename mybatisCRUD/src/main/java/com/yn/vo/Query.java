package com.yn.vo;

import com.yn.entity.User;

import java.io.Serializable;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/26-19:56
 */
public class Query implements Serializable {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
