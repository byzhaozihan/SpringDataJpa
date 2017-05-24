package com.zzh.repository;

import com.zzh.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans-new.xml"})
public class EmployeeJpaRepositoryTest {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Test
    public void testFind() {
        Employee employee = employeeJpaRepository.findOne(99);
        System.out.println(employee);
    }

    @Test
    public void testExists() {
        Boolean result1 = employeeJpaRepository.exists(25);
        Boolean result2 = employeeJpaRepository.exists(130);
        System.out.println("Employee-25: " + result1);
        System.out.println("Employee-130: " + result2);
    }
}