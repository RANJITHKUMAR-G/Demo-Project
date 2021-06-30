package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("select name from Employee")
	List<String> fetchAllNames();
	
}
