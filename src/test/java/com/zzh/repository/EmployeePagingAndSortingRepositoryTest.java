package com.zzh.repository;

import com.zzh.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans-new.xml"})
public class EmployeePagingAndSortingRepositoryTest {

    @Autowired
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository;

    @Test
    public void testPage() {

        //第0页，每页5条记录
        Pageable pageable = new PageRequest(0, 5);
        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);

        System.out.println("查询的总页数："+ page.getTotalPages());
        System.out.println("总记录数："+ page.getTotalElements());
        System.out.println("当前第几页：" + page.getNumber() + 1);
        System.out.println("当前页面对象的集合："+ page.getContent());
        System.out.println("当前页面的记录数："+ page.getNumberOfElements());
    }

    @Test
    public void testPageAndSort() {

        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(0, 5, sort);
        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);

        System.out.println("查询的总页数："+ page.getTotalPages());
        System.out.println("总记录数："+ page.getTotalElements());
        System.out.println("当前第几页：" + page.getNumber() + 1);
        System.out.println("当前页面对象的集合："+ page.getContent());
        System.out.println("当前页面的记录数："+ page.getNumberOfElements());
    }

}