package com.zzh.dao;

import com.zzh.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAOSpringJdbcImpl implements StudentDAO{

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Student> query() {
        final List<Student> students = new ArrayList<>();
        String sql = "select * from student";

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                Student student = new Student();
                student.setId(id);
                student.setAge(age);
                student.setName(name);

                students.add(student);
            }
        });
        return students;
    }

    @Override
    public void save(Student student) {

        String sql = "insert into student(name,age) values (?,?)";
        jdbcTemplate.update(sql, new Object[]{student.getName(), student.getAge()});
    }
}
