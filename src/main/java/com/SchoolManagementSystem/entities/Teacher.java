package com.SchoolManagementSystem.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Teacher {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private Long id;
	    private String name;
	    private String email;
	   
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	            name = "teacher_courses",
	            joinColumns = @JoinColumn(name = "teacher_id"),
	            inverseJoinColumns = @JoinColumn(name = "course_id")
	    )
//	    @JsonManagedReference
	    private List<Course> courses;

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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<Course> getCourses() {
			return courses;
		}

		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}

		public Teacher(Long id, String name, String email, List<Course> courses) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.courses = courses;
		}

		public Teacher() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Teacher [id=" + id + ", name=" + name + ", email=" + email + ", courses=" + courses + "]";
		} 
	    
	    
	    
	    
	    

}
