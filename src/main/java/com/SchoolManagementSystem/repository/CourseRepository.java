package com.SchoolManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SchoolManagementSystem.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
	// Custom query method 
	Course findByCode(String code); 
	

}
