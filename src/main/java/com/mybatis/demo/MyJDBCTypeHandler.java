package com.mybatis.demo;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lihuiyan on 2017/3/8.
 */
public class MyJDBCTypeHandler extends BaseTypeHandler {
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        System.out.println("setNonNullParameter");
        preparedStatement.setString(i, String.valueOf(o));

    }
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("getNullableResult(ResultSet resultSet, String s)");
        return resultSet.getString(s);
    }

    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("get2");
        return resultSet.getString(i);
    }

    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println("get3");
        return callableStatement.getString(i);
    }
}
