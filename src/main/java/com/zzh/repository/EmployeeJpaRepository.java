package com.zzh.repository;


import com.zzh.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer>{
}
