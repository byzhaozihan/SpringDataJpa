package com.zzh.repository;

import com.zzh.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans-new.xml"})
public class EmployeeJpaSpecificationExecutorTest {

    @Autowired
    private EmployeeJpaSpecificationExecutor employeeJpaSpecificationExecutor;

    /**
     * 分页
     * 排序
     * 查询条件: age > 50
     */
    @Test
    public void testQuery() {

        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(0, 5, sort);

        /**
         * root:查询的类型（Employee）
         * query：添加查询条件
         * cb:构建Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path path = root.get("age");
                return cb.gt(path, 50);
            }
        };

        Page<Employee> page = employeeJpaSpecificationExecutor.findAll(specification, pageable);

        System.out.println("查询的总页数："+ page.getTotalPages());
        System.out.println("总记录数："+ page.getTotalElements());
        System.out.println("当前第几页：" + page.getNumber() + 1);
        System.out.println("当前页面对象的集合："+ page.getContent());
        System.out.println("当前页面的记录数："+ page.getNumberOfElements());

    }

}