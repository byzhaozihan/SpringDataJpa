package com.zzh.dao;

import com.zzh.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})
public class StudentDAOSpringJdbcImplTest {


    @Resource
    private StudentDAO studentDAO;


    @Test
    public void query() throws Exception {

        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId() + "age:" + student.getAge() + "name:" + student.getName());
        }
    }

    @Test
    public void save() throws Exception {
        Student student = new Student();
        student.setName("spring-jdbc");
        student.setAge(40);

        studentDAO.save(student);
    }

}