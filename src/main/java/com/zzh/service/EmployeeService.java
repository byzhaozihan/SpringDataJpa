package com.zzh.service;

import com.zzh.domain.Employee;
import com.zzh.repository.EmployeeCrudRepository;
import com.zzh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void update(Integer id, Integer age) {
        employeeRepository.update(id,age);
    }

    @Transactional
    public void delete(Integer id) {
        employeeRepository.delete(id);
    }

    @Transactional
    public void save(List<Employee> employees) {
        employeeCrudRepository.save(employees);
    }
}
