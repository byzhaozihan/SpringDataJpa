package com.zzh.dao;

import com.zzh.domain.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class StudentDAOImplTest {
    @Test
    public void query() throws Exception {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId() + "age:" + student.getAge() + "name:" + student.getName());
        }
    }

    @Test
    public void save() {

        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setAge(20);
        student.setName("test");
        studentDAO.save(student);
    }
}