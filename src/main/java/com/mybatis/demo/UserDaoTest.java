package com.mybatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by lihuiyan on 2017/3/7.
 */
public class UserDaoTest {
    @Test
    public void testMain() throws IOException {
        insertUser();
        findUserById();
        updateUser();
        deleteUser();
    }

    public void findUserById() throws IOException {
//        //别名验证
//        Configuration con = getSessionFactory().getConfiguration();
//        Map<String,Class<?>> typeMap = con.getTypeAliasRegistry().getTypeAliases();
//        for(Map.Entry<String,Class<?>> entry:typeMap.entrySet()){
//            System.out.println(entry.getKey()+"-----"+entry.getValue());
//        }
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        User user = userMapper.getUserById(1);
        System.out.println(user.getUserId() + "," + user.getUserName());

//        User user1 = new User();
//        user1.setUserName("aa");
//        List<User> list = userMapper.queryUsers(user1);
//        System.out.println(list.get(0).getUserName());
    }

    private static void deleteUser() {
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        userMapper.deleteUser(9);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void updateUser() {
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("cc");
        user1.setAge(33);
        user1.setCompany("ali");
        userMapper.updateUser(user1);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void insertUser() {
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        User user1 = new User();
        user1.setUserName("bb");
        user1.setAge(22);
        user1.setCompany("JD");
        userMapper.insertUser(user1);
        sqlSession.commit();
        sqlSession.close();
    }

    //Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
    private static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "mybatis-config.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}