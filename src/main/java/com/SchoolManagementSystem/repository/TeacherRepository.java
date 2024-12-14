package com.SchoolManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SchoolManagementSystem.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	
	Teacher findByEmail(String email); 

}
