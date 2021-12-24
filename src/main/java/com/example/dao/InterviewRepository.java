package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entities.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long>{

	@Transactional
	@Modifying
	@Query("delete Interview u where u.id_Interview=:code")
	void deleteInterview(@PathVariable("code") long code);
	
}
