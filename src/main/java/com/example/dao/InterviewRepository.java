package com.example.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Condidats;
import com.example.entities.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long>{
	@Query("select o from Interview o")
	public Collection<Interview> findAllInterviews();
}
