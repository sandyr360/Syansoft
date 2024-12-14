package com.SchoolManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SchoolManagementSystem.entities.Student;
import com.SchoolManagementSystem.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
//    @Cacheable(value = "students_all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

//    public Student getStudentById(Long id) {
//        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
//    }
//    @Cacheable(value = "students", key = "#id")
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);  // Return null if not found
    }
    
    public Student updateStudent(Long id, Student studentDetails) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
//            student.setPassword(studentDetails.getPassword());
            // Update other fields as needed
            return studentRepository.save(student);
        }
        return null;
    }
    
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);  // Custom query to find by email
    }

//    public void deleteStudent(Long id) {
//        studentRepository.deleteById(id);
//    }
//    @Transactional
    public boolean deleteStudent(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true;
        }
        return false;
    }

}
