package com.SchoolManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SchoolManagementSystem.entities.Course;
import com.SchoolManagementSystem.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);  // Save a new course
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();  // Get all courses
    }

    public Course getCourseById(Long id) {
    	Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);  // Return null if not found
    }
//        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    

    public Course getCourseByCode(String code) {
        return courseRepository.findByCode(code);  // Custom query to find by course code
    }

//    public void deleteCourse(Long id) {
//        courseRepository.deleteById(id);  // Delete course by ID
    public boolean deleteCourse(Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            courseRepository.delete(courseOptional.get());
            return true;
        }
        return false;
    }

}
