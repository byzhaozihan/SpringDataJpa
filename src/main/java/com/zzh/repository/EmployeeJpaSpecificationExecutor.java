package com.zzh.repository;


import com.zzh.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface EmployeeJpaSpecificationExecutor extends JpaSpecificationExecutor<Employee>,JpaRepository<Employee,Integer> {
}
