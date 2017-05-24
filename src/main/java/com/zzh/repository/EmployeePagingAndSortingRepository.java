package com.zzh.repository;


import com.zzh.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Integer> {

}
