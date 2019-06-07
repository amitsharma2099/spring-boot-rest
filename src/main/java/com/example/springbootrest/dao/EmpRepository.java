package com.example.springbootrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springbootrest.model.Employee;


public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
