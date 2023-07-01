package com.dao;

import com.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class StudentDao {

    QueryRunner queryRunner = null;
    Connection connection = null;

    public StudentDao() {
        connection =  new ConnectionUtils("D:\\class1\\maven_demo_web\\src\\main\\resources\\jdbc.properties").getConnection();
        queryRunner = new QueryRunner();
    }
    public String getFirstStudentName() {
        String sql = "select stuname from student limit 0,1";
        String stuName = "";
        try {
            stuName = (String) queryRunner.query(connection, sql, new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return stuName;
    }

}
