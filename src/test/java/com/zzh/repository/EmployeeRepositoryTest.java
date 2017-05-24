package com.zzh.repository;


import com.zzh.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeRepository employeeRepository = null;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
    }

    @After
    public void tearDown() throws Exception {
        ctx = null;
    }

    @Test
    public void findByName() throws Exception {
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println("id:" + employee.getId() + " name:" + employee.getName() + " age:" + employee.getAge());
    }
    @Test
    public void findByNameStartingWithAndAgeLessThan() throws Exception {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test",22);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " name:" + employee.getName() + " age:" + employee.getAge());
        }
    }


    @Test
    public void findByNameEndingWithAndAgeLessThan() throws Exception {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6",23);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " name:" + employee.getName() + " age:" + employee.getAge());
        }
    }

    @Test
    public void findByNameInAndAgeLessThan() throws Exception {
        List<String> names = new ArrayList<>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names,22);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " name:" + employee.getName() + " age:" + employee.getAge());
        }
    }


    @Test
    public void getEmployeeByMaxId() throws Exception {
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println("id:" + employee.getId() + " name:" + employee.getName() + " age:" + employee.getAge());
    }

    @Test
    public void queryParams1() throws Exception {
        List<Employee> employees = employeeRepository.queryParams1("zhangsan", 20);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " name:" + employee.getName() + " age:" + employee.getAge());
        }
    }

    @Test
    public void queryParams2() throws Exception {
        List<Employee> employees = employeeRepository.queryParams2("zhangsan", 20);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " name:" + employee.getName() + " age:" + employee.getAge());
        }
    }

    @Test
    public void queryLike1() throws Exception {
        List<Employee> employees = employeeRepository.queryLike1("test");
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " name:" + employee.getName() + " age:" + employee.getAge());
        }
    }
    @Test
    public void queryLike2() throws Exception {
        List<Employee> employees = employeeRepository.queryLike2("test1");
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " name:" + employee.getName() + " age:" + employee.getAge());
        }
    }

    @Test
    public void getCount() throws Exception {
        long count = employeeRepository.getCount();
        System.out.println("count:" + count);

    }
}