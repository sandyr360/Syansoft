package com.SchoolManagementSystem.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    private String code;

	    // Changed from Set to List for maintaining order
	    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
	    @JsonBackReference
	    private List<Student> students;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public List<Student> getStudents() {
			return students;
		}

		public void setStudents(List<Student> students) {
			this.students = students;
		}

		public Course(Long id, String name, String code, List<Student> students) {
			super();
			this.id = id;
			this.name = name;
			this.code = code;
			this.students = students;
		}

		public Course() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Course [id=" + id + ", name=" + name + ", code=" + code + ", students=" + students + "]";
		}
	    
	    
    
    

}
