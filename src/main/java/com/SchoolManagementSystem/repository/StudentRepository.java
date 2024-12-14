package com.SchoolManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SchoolManagementSystem.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findByEmail(String email);

}
