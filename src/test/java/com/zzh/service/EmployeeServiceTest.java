package com.zzh.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class EmployeeServiceTest {
    private ApplicationContext ctx = null;

    private EmployeeService employeeService = null;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = ctx.getBean(EmployeeService.class);
    }

    @After
    public void tearDown() throws Exception {
        ctx = null;
    }

    @Test
    public void update() throws Exception {
        employeeService.update(1,55);
    }

    @Test
    public void delete() throws Exception {
        employeeService.delete(9);
    }

}