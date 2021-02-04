package com.yn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yn
 * @class my-ssm-study
 * @describe
 * @date 2021/1/20-20:52
 */
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private Date userBirthday;
    private String UserSex;
    private String UserAddress;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserSex() {
        return UserSex;
    }

    public void setUserSex(String userSex) {
        UserSex = userSex;
    }

    public String getUserAddress() {
        return UserAddress;
    }

    public void setUserAddress(String userAddress) {
        UserAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userBirthday=" + userBirthday +
                ", UserSex='" + UserSex + '\'' +
                ", UserAddress='" + UserAddress + '\'' +
                '}';
    }
}

