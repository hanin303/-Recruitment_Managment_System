package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long>{

}
