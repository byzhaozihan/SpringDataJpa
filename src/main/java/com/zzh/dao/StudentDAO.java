package com.zzh.dao;

import com.zzh.domain.Student;

import java.util.List;

/**
 * Created by zhao on 2017/5/22.
 */
public interface StudentDAO {

    //查询所以学生
    List<Student> query();

    void save(Student student);
}
