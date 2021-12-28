package com.example.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Employee;
import com.example.entities.User;

public interface EmployeRepository extends JpaRepository<Employee,Integer>{

}
