package com.zzh.dao;

import com.zzh.domain.Student;
import com.zzh.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2017/5/22.
 */
public class StudentDAOImpl implements StudentDAO{

    /**
     * 查询学生
     */
    @Override
    public List<Student> query() {

        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from student";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            Student student = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                student = new Student();
                student.setId(id);
                student.setAge(age);
                student.setName(name);

                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
        return students;
    }

    /**
     * 添加学生
     */
    @Override
    public void save(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "insert into student(name,age) values (?,?)";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
    }
}
