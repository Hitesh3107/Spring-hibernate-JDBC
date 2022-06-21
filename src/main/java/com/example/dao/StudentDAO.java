package com.example.dao;

import java.util.List;

import com.example.model.Student;

public interface StudentDAO {
	
	public List<Student> getStudents();

	public void addStudent(Student s);
}
