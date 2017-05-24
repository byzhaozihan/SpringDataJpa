package com.zzh.repository;


import com.zzh.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCrudRepository extends CrudRepository<Employee,Integer>{

}
