package com.zzh.repository;

import com.zzh.domain.Employee;
import com.zzh.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans-new.xml"})
public class EmployeeCrudRepositoryTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSave() {
        List<Employee> employees = new ArrayList<>();

        Employee employee = null;
        for (int i = 0; i < 100; i++) {
            employee = new Employee();
            employee.setName("test" + i);
            employee.setAge(100 - i);
            employees.add(employee);
        }
        employeeService.save(employees);
    }
}