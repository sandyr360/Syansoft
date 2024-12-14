package com.SchoolManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SchoolManagementSystem.entities.Teacher;
import com.SchoolManagementSystem.repository.TeacherRepository;

@Service
public class TeacherService {
	
	 @Autowired
	    private TeacherRepository teacherRepository;

	    // Save or update a teacher
	    public Teacher saveTeacher(Teacher teacher) {
	        return teacherRepository.save(teacher);
	    }

	    // Get all teachers
	    public List<Teacher> getAllTeachers() {
	        return teacherRepository.findAll();
	    }

	    // Get a teacher by ID
	    public Teacher getTeacherById(Long id) {
//	        return teacherRepository.findById(id)
//	                .orElseThrow(() -> new RuntimeException("Teacher not found"));
	    	Optional<Teacher> teacher = teacherRepository.findById(id);
	        return teacher.orElse(null);  // Return null if not found
	    
	    }

	    // Get a teacher by email
	    public Teacher getTeacherByEmail(String email) {
	        return teacherRepository.findByEmail(email);  // Custom query method
	    }

	    // Delete a teacher by ID
//	    public void deleteTeacher(Long id) {
//	        teacherRepository.deleteById(id);
//	    }
	    
	    public boolean deleteTeacher(Long id) {
	        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
	        if (teacherOptional.isPresent()) {
	            teacherRepository.delete(teacherOptional.get());
	            return true;
	        }
	        return false;
	    }

}
