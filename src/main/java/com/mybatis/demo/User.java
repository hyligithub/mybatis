package com.mybatis.demo;

import java.io.Serializable;

/**
 * Created by lihuiyan on 2017/3/7.
 */
public class User implements Serializable {
    private int userId;
    private String userName;
    private int age;
    private String company;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
