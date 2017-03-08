package com.mybatis.demo;

import java.io.IOException;
import java.util.List;

/**
 * Created by lihuiyan on 2017/3/7.
 */
public interface UserDao {

    public User getUserById(int id);

    public List<User> queryUsers(User user) throws IOException;

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);
}
